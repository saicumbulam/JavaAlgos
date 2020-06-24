package ObjectOrientedInterview.ParkingLot;

public abstract class Vehicle {
    private String licenseNumber;
    public final Constants.VehicleType type;
    private String ticket;

    public Vehicle(Constants.VehicleType type) {
        this.type = type;
    }

    public void assignTicket(String ticket) {
        this.ticket = ticket;
    }
}

class Car extends Vehicle {
    public Car() {
        super(Constants.VehicleType.CAR);
    }
}

class Van extends Vehicle {
    public Van() {
        super(Constants.VehicleType.VAN);
    }
}

class Truck extends Vehicle {
    public Truck() {
        super(Constants.VehicleType.TRUCK);
    }
}