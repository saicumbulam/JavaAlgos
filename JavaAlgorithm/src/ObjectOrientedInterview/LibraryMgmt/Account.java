package ObjectOrientedInterview.LibraryMgmt;

public abstract class Account {
    private String id;
    private String password;
    private Constants.AccountStatus status;
    private Person person;

    public boolean resetPassword() {
        return true;
    }
}
