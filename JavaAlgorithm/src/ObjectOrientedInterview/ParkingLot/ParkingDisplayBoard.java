package ObjectOrientedInterview.ParkingLot;

public class ParkingDisplayBoard {
    private String id;
    private HandicappedSpot handicappedFreeSpot;
    private CompactSpot compactFreeSpot;
    private LargeSpot largeFreeSpot;
    private MotorbikeSpot motorbikeFreeSpot;
    private ElectricSpot electricFreeSpot;

    public void showEmptySpotNumber() {
        String message = "";
        if(handicappedFreeSpot.IsFree()){
            message += "Free Handicapped: " + handicappedFreeSpot.number;
        } else {
            message += "Handicapped is full";
        }
        message += System.lineSeparator();

        if(compactFreeSpot.IsFree()){
            message += "Free Compact: " + compactFreeSpot.number;
        } else {
            message += "Compact is full";
        }
        message += System.lineSeparator();

        if(largeFreeSpot.IsFree()){
            message += "Free Large: " + largeFreeSpot.number;
        } else {
            message += "Large is full";
        }
        message += System.lineSeparator();

        if(motorbikeFreeSpot.IsFree()){
            message += "Free Motorbike: " + motorbikeFreeSpot.number;
        } else {
            message += "Motorbike is full";
        }
        message += System.lineSeparator();

        if(electricFreeSpot.IsFree()){
            message += "Free Electric: " + electricFreeSpot.number;
        } else {
            message += "Electric is full";
        }

        Show(message);
    }

    private void Show(String message) { return; }

    public ParkingSpot getHandicappedFreeSpot() {
        return null;
    }

    public void setHandicappedFreeSpot(HandicappedSpot handicappedSpot) {
    }

    public ParkingSpot getCompactFreeSpot() { return null; }

    public void setCompactFreeSpot(CompactSpot compactSpot) {
    }
}
