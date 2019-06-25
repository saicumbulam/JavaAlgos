package DesignPattern.Bridge;

public class CentralLocking implements Product {
    private final String productName;

    public CentralLocking(String productName){
        this.productName = productName;
    }

    @Override
    public String productName(){
        return productName;
    }

    @Override
    public void produce(){
        System.out.println("Producing central locking system");
    }
}


