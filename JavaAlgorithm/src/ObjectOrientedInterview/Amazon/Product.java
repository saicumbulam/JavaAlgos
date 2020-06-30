package ObjectOrientedInterview.Amazon;

public class Product {
    private String productID;
    private String name;
    private String description;
    private double price;
    private ProductCategory category;
    public int availableItemCount;

    private Account seller;

    public boolean updatePrice(double newPrice)
    {
        price = newPrice;
        return true;
    }
}


class ProductCategory {
    private String name;
    private String description;
}

class ProductReview {
    private int rating;
    private String review;

    private Member reviewer;
}
