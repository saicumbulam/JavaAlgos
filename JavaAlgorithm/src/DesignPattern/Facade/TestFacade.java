package DesignPattern.Facade;

public class TestFacade {
    public static void main(String[] args) {
        ScheduleServer scheduleServer = new ScheduleServer();
        ScheduleServerFacade serverFacade = new ScheduleServerFacade(scheduleServer);

        System.out.println(" Start working.. ");
        System.out.println(" After workdone.. ");

        serverFacade.stopServer();

    }
}
