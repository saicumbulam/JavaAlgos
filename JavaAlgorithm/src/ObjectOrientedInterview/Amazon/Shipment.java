package ObjectOrientedInterview.Amazon;

import java.util.Date;
import java.util.List;

public class Shipment {
    private String shipmentNumber;
    private Date shipmentDate;
    private Date estimatedArrival;
    private String shipmentMethod;
    private List<ShipmentLog> shipmentLogs;

    public boolean addShipmentLog(ShipmentLog shipmentLog)
    {
        shipmentLogs.add(shipmentLog);
        return true;
    }
}


abstract class Notification {
    private int notificationId;
    private Date createdOn;
    private String content;

    public boolean sendNotification(Account account) { return true; }
}

class ShipmentLog {
    private String shipmentNumber;
    private Constants.ShipmentStatus status;
    private Date creationDate;
}