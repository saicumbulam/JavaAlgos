package ObjectOrientedInterview.LibraryMgmt;

import java.util.Date;

public class BookReservation {
    private Date creationDate;
    private Constants.ReservationStatus status;
    private String bookItemBarcode;
    public String memberId;

    public static BookReservation fetchReservationDetails(String barcode)
    {
        return new BookReservation();
    }

    public void updateStatus(Constants.ReservationStatus completed) { }

    public void sendBookAvailableNotification() {  }
}
