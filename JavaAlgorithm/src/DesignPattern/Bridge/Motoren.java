package DesignPattern.Bridge;

public class Motoren extends Car{
    private final Product product;
    private final String carType;

    public Motoren(Product product, String carType) {
        // super used for inheritance usage in java
        super(product, carType);
        this.product = product;
        this.carType = carType;
    }
    @Override
    public void assemble() {
        System.out.println("Assembling "+product.productName()+" for "+carType);
    }
    @Override
    public void produceProduct() {
        product.produce();
        System.out.println("Modifing product "+product.productName()+" according to "+carType);
    }
}