package ObjectOrientedInterview.ParkingLot;

import java.util.HashMap;

public class ParkingLot {
    private String name;
    private Address address;
    private int parkingRate;

    private int compactSpotCount;
    private int largeSpotCount;
    private int motorbikeSpotCount;
    private int electricSpotCount;
    private int maxCompactCount;
    private int maxLargeCount;
    private int maxMotorbikeCount;
    private int maxElectricCount;

    private HashMap<String, String> entrancePanels;
    private HashMap<String, String> exitPanels;
    private HashMap<String, ParkingFloor> parkingFloors;

    // all active parking tickets, identified by their ticketNumber
    private HashMap<String, String> activeTickets;

    // singleton ParkingLot to ensure only one object of ParkingLot in the system,
    // all entrance panels will use this object to create new parking ticket: getNewParkingTicket(),
    // similarly exit panels will also use this object to close parking tickets
    private static ParkingLot parkingLot = null;

    // private constructor to restrict for singleton
    private ParkingLot() {
        // 1. initialize variables: read name, address and parkingRate from database
        // 2. initialize parking floors: read the parking floor map from database,
        //  this map should tell how many parking spots are there on each floor. This
        //  should also initialize max spot counts too.
        // 3. initialize parking spot counts by reading all active tickets from database
        // 4. initialize entrance and exit panels: read from database
    }

    // static method to get the singleton instance of ParkingLot
    public static ParkingLot getInstance() {
        if (parkingLot == null) {
            parkingLot = new ParkingLot();
        }
        return parkingLot;
    }

    // note that the following method is 'synchronized' to allow multiple entrances
    // panels to issue a new parking ticket without interfering with each other
    public synchronized String getNewParkingTicket(Vehicle vehicle)
            throws Exception {
        if (this.isFull(vehicle.type)) {
            throw new Exception();
        }
        String ticket = "";
        vehicle.assignTicket(ticket);

        // if the ticket is successfully saved in the database, we can increment the parking spot count
        this.incrementSpotCount(vehicle.type);
        this.activeTickets.put(ticket, ticket);
        return ticket;
    }

    public boolean isFull(Constants.VehicleType type) {
        // trucks and vans can only be parked in LargeSpot
        if (type == Constants.VehicleType.TRUCK ||
                type == Constants.VehicleType.VAN) {
            return largeSpotCount >= maxLargeCount;
        }

        // motorbikes can only be parked at motorbike spots
        if (type == Constants.VehicleType.MOTORBIKE) {
            return motorbikeSpotCount >= maxMotorbikeCount;
        }

        // cars can be parked at compact or large spots
        if (type == Constants.VehicleType.CAR) {
            return (compactSpotCount + largeSpotCount) >=
                    (maxCompactCount + maxLargeCount);
        }

        // electric car can be parked at compact, large or electric spots
        return (compactSpotCount + largeSpotCount + electricSpotCount) >= (maxCompactCount + maxLargeCount
                + maxElectricCount);
    }

    // increment the parking spot count based on the vehicle type
    private boolean incrementSpotCount(Constants.VehicleType type) {
        if (type == Constants.VehicleType.TRUCK ||
                type == Constants.VehicleType.VAN) {
            largeSpotCount++;
        } else if (type == Constants.VehicleType.MOTORBIKE) {
            motorbikeSpotCount++;
        } else if (type == Constants.VehicleType.CAR) {
            if (compactSpotCount < maxCompactCount) {
                compactSpotCount++;
            } else {
                largeSpotCount++;
            }
        } else { // electric car
            if (electricSpotCount < maxElectricCount) {
                electricSpotCount++;
            } else if (compactSpotCount < maxCompactCount) {
                compactSpotCount++;
            } else {
                largeSpotCount++;
            }
        }
        return true;
    }

    public boolean isFull() {
        for (String key : parkingFloors.keySet()) {
            if (!parkingFloors.get(key).isFull()) {
                return false;
            }
        }
        return true;
    }

    public void addParkingFloor(ParkingFloor floor) {
        /* store in database */ }

    public void addEntrancePanel(String entrancePanel) {
        /* store in database */ }

    public void addExitPanel(String exitPanel) {
        /* store in database */ }
}
