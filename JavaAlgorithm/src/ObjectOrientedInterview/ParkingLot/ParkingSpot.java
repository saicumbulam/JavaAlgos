package ObjectOrientedInterview.ParkingLot;

public abstract class ParkingSpot {
    public String number;
    public boolean free;
    private Vehicle vehicle;
    public final Constants.ParkingSpotType type;

    public boolean IsFree(){return true;}

    public ParkingSpot(Constants.ParkingSpotType type) {
        this.type = type;
    }

    public boolean assignVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        free = false;
        return true;
    }

    public boolean removeVehicle() {
        this.vehicle = null;
        free = true;
        return true;
    }
}



class HandicappedSpot extends ParkingSpot {
    public HandicappedSpot() {
        super(Constants.ParkingSpotType.HANDICAPPED);
    }
}

class CompactSpot extends ParkingSpot {
    public CompactSpot() {
        super(Constants.ParkingSpotType.COMPACT);
    }
}

class LargeSpot extends ParkingSpot {
    public LargeSpot() {
        super(Constants.ParkingSpotType.LARGE);
    }
}

class MotorbikeSpot extends ParkingSpot {
    public MotorbikeSpot() {
        super(Constants.ParkingSpotType.MOTORBIKE);
    }
}

class ElectricSpot extends ParkingSpot {
    public ElectricSpot() {
        super(Constants.ParkingSpotType.ELECTRIC);
    }
}
