package ObjectOrientedInterview.LibraryMgmt;

import java.time.LocalDate;
import java.util.Date;

public class Member {
    private Date dateOfMembership;
    private int totalBooksCheckedout;

    public int getTotalBooksCheckedout() { return 0; }

    public boolean reserveBookItem(BookItem bookItem) { return true; }

    private void incrementTotalBooksCheckedout() { }

    public boolean checkoutBookItem(BookItem bookItem) {
        if (getTotalBooksCheckedOut() >= Constants.MAX_BOOKS_ISSUED_TO_A_USER) {
            ShowError("The user has already checked-out maximum number of books");
            return false;
        }
        BookReservation bookReservation =
                BookReservation.fetchReservationDetails(bookItem.barcode);
        if (bookReservation != null && bookReservation.memberId != getId()) {
            // book item has a pending reservation from another user
            ShowError("This book is reserved by another member");
            return false;
        } else if (bookReservation != null) {
            // book item has a pending reservation from the give member, update it
            bookReservation.updateStatus(Constants.ReservationStatus.COMPLETED);
        }

        if (!bookItem.checkout(getId())) {
            return false;
        }

        this.incrementTotalBooksCheckedout();
        return true;
    }

    private String getId() { return ""; }

    private int getTotalBooksCheckedOut() { return 0; }

    private void ShowError(String s) { }

    private void checkForFine(String bookItemBarcode) {
        BookLending bookLending = BookLending.fetchLendingDetails(bookItemBarcode);
        Date dueDate = bookLending.dueDate;
        Date today = new Date();
        // check if the book has been returned within the due date
        if (today.compareTo(dueDate) > 0) {
            long diff = today.getTime() - dueDate.getTime();
            long diffDays = diff / (24 * 60 * 60 * 1000);
            String memberId = "";
            Fine.collectFine(memberId, diffDays);
        }
    }

    public void returnBookItem(BookItem bookItem) {
        this.checkForFine(bookItem.barcode);
        BookReservation bookReservation =
                BookReservation.fetchReservationDetails(bookItem.barcode);
        if (bookReservation != null) {
            // book item has a pending reservation
            bookItem.updateBookItemStatus(Constants.BookStatus.RESERVED);
            bookReservation.sendBookAvailableNotification();
        }
        bookItem.updateBookItemStatus(Constants.BookStatus.AVAILABLE);
    }

    public boolean renewBookItem(BookItem bookItem) {
        this.checkForFine(bookItem.barcode);
        BookReservation bookReservation =
                BookReservation.fetchReservationDetails(bookItem.barcode);
        // check if this book item has a pending reservation from another member
        if (bookReservation != null && bookReservation.memberId != getMemberId()) {
            ShowError("This book is reserved by another member");
            decrementTotalBooksCheckedout();
            bookItem.updateBookItemState(Constants.BookStatus.RESERVED);
            bookReservation.sendBookAvailableNotification();
            return false;
        } else if (bookReservation != null) {
            // book item has a pending reservation from this member
            bookReservation.updateStatus(Constants.ReservationStatus.COMPLETED);
        }
        BookLending.lendBook(bookItem.barcode, getMemberId());
        bookItem.updateDueDate(LocalDate.now().plusDays(Constants.MAX_LENDING_DAYS));
        return true;
    }

    private void decrementTotalBooksCheckedout() { }

    private String getMemberId() { return ""; }
}
