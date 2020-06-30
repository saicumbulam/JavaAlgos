package ObjectOrientedInterview.Amazon;

public class Constants {
    public enum OrderStatus {
        UNSHIPPED, PENDING, SHIPPED, COMPLETED, CANCELED, REFUND_APPLIED
    }

    public enum AccountStatus {
        ACTIVE, BLOCKED, BANNED, COMPROMISED, ARCHIVED, UNKNOWN
    }

    public enum ShipmentStatus {
        PENDING, SHIPPED, DELIVERED, ON_HOLD,
    }

    public enum PaymentStatus {
        UNPAID, PENDING, COMPLETED, FILLED, DECLINED, CANCELLED, ABANDONED, SETTLING, SETTLED, REFUNDED
    }
}
