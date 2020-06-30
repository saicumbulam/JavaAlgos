package DesignPattern;

/*This type of design pattern comes under creational pattern as this
pattern provides one of the best ways to create an object.

This pattern involves a single class which is responsible to create an
object while making sure that only single object gets created.
This class provides a way to access its only object which can be accessed
directly without need to instantiate the object of the class.
*/

public class Singleton {
    private static volatile Singleton instance = null;

    private Singleton(){
        if (instance != null) {
            throw new RuntimeException("Use getInstance() method to create");
        }
    }

    public static Singleton getInstance(){
        if (instance == null) {
            synchronized (Singleton.class){
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
