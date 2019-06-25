package DesignPattern.RemoteProxy;

import java.rmi.Naming;

public class RemoteGeneratorClient {
    public static void main(String[] args) {
        new RemoteGeneratorClient().generateReport();
    }
    public void generateReport(){
        try {
            ReportGenerator reportGenerator = (ReportGenerator) Naming.lookup("rmi://127.0.0.1/PizzaCo" +
                    "RemoteGenerator");
            System.out.println(reportGenerator.generateDailyReport());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
