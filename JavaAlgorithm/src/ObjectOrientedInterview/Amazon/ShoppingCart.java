package ObjectOrientedInterview.Amazon;

import java.util.Date;
import java.util.List;

public class ShoppingCart {
    private List<Item> items;

    public boolean addItem(Item item){items.add(item); return true;}

    public boolean removeItem(Item item){items.remove(item); return true;}

    public boolean updateItemQuantity(Item item, int quantity){
        //items.get(item).updateQuantity(quantity);
        return true;
    }
    public List<Item> getItems() { return  items; }
    public boolean checkout(){return true;}
}

class Item {
    private String productID;
    private int quantity;
    private double price;

    public boolean updateQuantity(int quantity) {
        this.quantity = quantity;
        return true;
    }
}



class OrderLog {
    private String orderNumber;
    private Date creationDate;
    private Constants.OrderStatus status;
}

class Order {
    private String orderNumber;
    private Constants.OrderStatus status;
    private Date orderDate;
    private List<OrderLog> orderLogs;

    public boolean sendForShipment() {return true;}
    public boolean makePayment(Payment payment){return true;}
    public boolean addOrderLog(OrderLog orderLog)
    {   orderLogs.add(orderLog);
        return true;
    }
}

class Payment {}