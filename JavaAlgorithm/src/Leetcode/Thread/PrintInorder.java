package Leetcode.Thread;

import java.util.concurrent.Semaphore;

public class PrintInorder {
    private static Semaphore twoSemaphore;
    private static Semaphore threeSemaphore;

    public static void main(String[] args) throws InterruptedException {
        twoSemaphore = new Semaphore(1);
        threeSemaphore = new Semaphore(1);
        twoSemaphore.acquire();
        threeSemaphore.acquire();

        int[] arr = {1,2,3};

        for (int item: arr
             ) {
            if (item == 1) {
                Thread t1= new Thread(new PrintFirst());
                t1.start();
            }
            if (item == 2) {
                Thread t2= new Thread(new PrintSecond());
                t2.start();
            } else {
                Thread t3= new Thread(new PrintThird());
                t3.start();
            }
        }
    }


    private static void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        twoSemaphore.release();
    }

    public static void second(Runnable printSecond) throws InterruptedException {

        twoSemaphore.acquire();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        threeSemaphore.release();
    }

    public static void third(Runnable printThird) throws InterruptedException {

        threeSemaphore.acquire();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }


    static class PrintFirst implements Runnable {

        @Override
        public void run() {
            System.out.println("first");
            twoSemaphore.release();
        }
    }
    static class PrintSecond implements Runnable {

        @Override
        public void run() {
            try {
                twoSemaphore.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("second");
            threeSemaphore.release();

        }
    }
    static class PrintThird implements Runnable {

        @Override
        public void run() {
            try {
                threeSemaphore.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("third");
        }
    }
}
