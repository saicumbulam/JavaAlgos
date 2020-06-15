package Threads.RandomPrograms;

public class MainThread {
    public static void main(String[] args) {
        Thread t = Thread.currentThread();
        System.out.println("Thread name: " + t.getName());

        t.setName("My thread");
        System.out.println("name changed: " + t.getName());

        try {
            for (int i = 0; i < 10; i++) {
                System.out.println(i);
                Thread.sleep(1000);
            }
        }catch (InterruptedException e)
        {
            System.out.println("Main thread interuppted");
        }
    }
}
