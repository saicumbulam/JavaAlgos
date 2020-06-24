package ObjectOrientedInterview.ParkingLot;

import ObjectOrientedInterview.LibraryMgmt.Constants;

public abstract class Account {
    private String userName;
    private String password;
    private Constants.AccountStatus status;
    private Person person;

    public boolean resetPassword() {return true;};
}