package ObjectOrientedInterview.LibraryMgmt;

import java.time.LocalDate;
import java.util.Date;

public class BookItem extends Book {
    public String barcode;
    private boolean isReferenceOnly;
    private Date borrowed;
    private Date dueDate;
    private double price;
    private Constants.BookFormat format;
    private Constants.BookStatus status;
    private Date dateOfPurchase;
    private Date publicationDate;
    private Rack placedAt;

    public boolean checkout(String memberId) {
        if(getIsReferenceOnly()) {
            ShowError("This book is Reference only and can't be issued");
            return false;
        }
        if(!BookLending.lendBook(barcode, memberId)){
            return false;
        }
        updateBookItemStatus(Constants.BookStatus.LOANED);
        return true;
    }

    private boolean getIsReferenceOnly() { return true; }

    private void ShowError(String s) { }

    void updateBookItemStatus(Constants.BookStatus loaned) { }

    public void updateDueDate(LocalDate plusDays) { }

    public void updateBookItemState(Constants.BookStatus reserved) { }
}