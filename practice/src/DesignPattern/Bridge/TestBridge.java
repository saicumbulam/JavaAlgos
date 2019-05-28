package DesignPattern.Bridge;

public class TestBridge {
    public static void main(String[] args) {

        Product centralLockingSystem = new CentralLocking("Central Locking System");
        Product gearLockingSystem = new GearLocking("Gear Locking System");

        Car car = new BigWheel(centralLockingSystem , "BigWheel xz model");
        car.produceProduct();
        car.assemble();
        car.printDetails();
        System.out.println();

        car = new BigWheel(gearLockingSystem , "BigWheel xz model");
        car.produceProduct();
        car.assemble();
        car.printDetails();

        car = new Motoren(centralLockingSystem, "Motoren lm model");
        car.produceProduct();
        car.assemble();
        car.printDetails();
        System.out.println();

        car = new Motoren(gearLockingSystem, "Motoren lm model");
        car.produceProduct();
        car.assemble();
        car.printDetails();
    }
}
