package ObjectOrientedInterview.LibraryMgmt;

import java.util.Date;

public class BookItem extends Book {
    private String barcode;
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
        if(!BookLending.lendBook(getBarCode(), memberId)){
            return false;
        }
        updateBookItemStatus(Constants.BookStatus.LOANED);
        return true;
    }

    private boolean getIsReferenceOnly() { return true; }

    private void ShowError(String s) { }

    private String getBarCode() { return ""; }

    private void updateBookItemStatus(Constants.BookStatus loaned) { }
}