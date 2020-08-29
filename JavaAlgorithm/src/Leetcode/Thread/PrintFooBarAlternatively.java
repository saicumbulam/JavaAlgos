package Leetcode.Thread;

import java.util.concurrent.Semaphore;

public class PrintFooBarAlternatively {
    private static Semaphore fooSemaphore;
    private static Semaphore barSemaphore;

    public static void main(String[] args) throws InterruptedException {
        fooSemaphore = new Semaphore(1);
        barSemaphore = new Semaphore(1);
        barSemaphore.acquire();

        int n = 2;
        for (int i = 0; i < n; i++) {
            Thread t2 = new Thread(new Bar());
            t2.start();
            Thread t1 = new Thread(new Foo());
            t1.start();


        }
    }


    static class Foo implements Runnable
    {

        @Override
        public void run() {
            try {
                fooSemaphore.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Foo");
            barSemaphore.release();
        }
    }


    static class Bar implements Runnable
    {

        @Override
        public void run() {
            try {
                barSemaphore.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Bar");
            fooSemaphore.release();
        }
    }
}
