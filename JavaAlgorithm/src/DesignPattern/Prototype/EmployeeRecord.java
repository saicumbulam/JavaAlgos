package DesignPattern.Prototype;


class EmployeeRecord implements prototype {

    private int id;
    private String name, destination;
    private double salary;
    private String address;

    public EmployeeRecord() {
        System.out.println("   Employee Records of Oracle Corporation ");
        System.out.println("---------------------------------------------");
        System.out.println("Eid" + "\t" + "Ename" + "\t" + "Edesignation" + "\t" + "Esalary" + "\t\t" + "Eaddress");
    }

    public EmployeeRecord(int id, String name, String destination, double salary, String address) {

        this();
        this.id = id;
        this.name = name;
        this.destination = destination;
        this.salary = salary;
        this.address = address;
    }

    public void showRecord(){
        System.out.println(id+"\t"+name+"\t"+destination+"\t"+salary+"\t"+address);
    }

    @Override
    public prototype getClone() {

        return new EmployeeRecord(id,name,destination,salary,address);
    }
}


