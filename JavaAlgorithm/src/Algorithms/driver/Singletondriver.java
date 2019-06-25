package Algorithms.driver;

import DesignPattern.Singleton;

public class Singletondriver {
    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
        System.out.println(instance);

        Singleton anotherinstance = Singleton.getInstance();
        System.out.println(anotherinstance);
    }
}
