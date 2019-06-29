package Algorithms.Sorting;

class Person {
    private String lastName;
    private String firstName;
    private int age;

    public Person(String last, String first, int a){
        lastName = last;
        firstName = first;
        age = a;
    }

    public void displayPerson(){
        System.out.println("Last name: " + lastName);
        System.out.println(", First name: " + firstName);
        System.out.println("Age: " + age);
    }

    public String getLast(){
        return lastName;
    }
}

class ArrayInOb{
    private Person[] a;
    private int nElems;

    public ArrayInOb(int max){
        a = new Person[max];
        nElems = 0;
    }

    public void insert(String last, String first, int age){
        a[nElems] = new Person(last, first, age);
        nElems++;
    }

    public void display(){
        for (int i = 0; i < nElems; i++) {
            System.out.println(a[i].getLast() + " ");
        }
    }

    public void insertionSort(){
        int in;

        for (int out = 0; out < nElems; out++) {
            Person temp = a[out];

            in = out;
            while (in > 0 && a[in-1].getLast().compareTo(temp.getLast()) > 0) {
                a[in] = a[in-1];
                --in;
            }
            a[in] = temp;
        }
    }
}


public class ObjectSort {
    public static void main(String[] args) {
        int maxSize = 100;
        ArrayInOb arr;

        arr = new ArrayInOb(maxSize);

        arr.insert("Evans", "Patty", 24);
        arr.insert("Smith", "Doc", 59);
        arr.insert("Smith", "Lorraine", 37);
        arr.insert("Smith", "Paul", 37);
        arr.insert("Yee", "Tom", 43);
        arr.insert("Hashimoto", "Sato", 21);
        arr.insert("Stimson", "Henry", 29);
        arr.insert("Velasquez", "Jose", 72);
        arr.insert("Vang", "Minh", 22);
        arr.insert("Creswell", "Lucinda", 18);

        arr.display();

        arr.insertionSort();

        arr.display();
    }
}
