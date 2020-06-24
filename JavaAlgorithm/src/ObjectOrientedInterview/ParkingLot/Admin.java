package ObjectOrientedInterview.ParkingLot;

public class Admin extends Account {
    public boolean addParkingFloor(ParkingFloor floor)
    {return true;}
    public boolean addParkingSpot(String floorName, ParkingSpot spot)
    {return true;}
    public boolean addParkingDisplayBoard(String floorName,
                                          ParkingDisplayBoard displayBoard)
    {return true;}
    public boolean addCustomerInfoPanel(String floorName,
                                        ParkingDisplayBoard infoPanel)
    {return true;}

    public boolean addEntrancePanel(String entrancePanel)
    {return true;}
    public boolean addExitPanel(String exitPanel)
    {return true;}
}


