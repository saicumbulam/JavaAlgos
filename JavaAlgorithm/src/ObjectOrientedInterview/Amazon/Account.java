package ObjectOrientedInterview.Amazon;

import java.util.List;

public class Account {
    private String userName;
    private String password;
    private Constants.AccountStatus status;
    private String name;
    private Address shippingAddress;
    private String email;
    private String phone;

    private List<CreditCard> creditCards;
    private List<ElectronicBankTransfer> bankAccounts;

    public boolean addProduct(Product product){return true;}
    public boolean addProductReview(ProductReview review){return true;}
    public boolean resetPassword(){return true;}
}


abstract class Customer {
    public ShoppingCart cart;
    private Order order;

    public boolean addItemToCart(Item item){return true;}
    public boolean removeItemFromCart(Item item){return true;}
}

class Guest extends Customer {
    public boolean registerAccount(){return true;}
}

class Member extends Customer {
    private Account account;
    public Constants.OrderStatus placeOrder(Order order){return Constants.OrderStatus.CANCELED; }
}

class ElectronicBankTransfer {
}
class CreditCard {
}