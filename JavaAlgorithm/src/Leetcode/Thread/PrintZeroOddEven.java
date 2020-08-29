package Leetcode.Thread;

import java.util.concurrent.Semaphore;

public class PrintZeroOddEven {
    private static Semaphore zeroSemaphore;
    private static Semaphore oddSemaphore;
    private static Semaphore evenSemaphore;
    private static int n;

    public static void main(String[] args) throws InterruptedException {
        zeroSemaphore = new Semaphore(1);
        oddSemaphore = new Semaphore(1);
        evenSemaphore = new Semaphore(1);
        oddSemaphore.acquire();
        evenSemaphore.acquire();

        n  = 2;
        Thread t0 = new Thread(new Zero());
        t0.start();

        Thread t1 = new Thread(new Odd());
        t1.start();

        Thread t2 = new Thread(new Even());
        t2.start();
    }


    static class Zero implements Runnable
    {

        @Override
        public void run() {
            for (int i = 0; i < n; i++) {
                try {
                    zeroSemaphore.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(0);
                if (i%2 == 1)
                {
                    oddSemaphore.release();
                }
                else
                {
                    evenSemaphore.release();
                }
            }
        }
    }


    static class Odd implements Runnable
    {

        @Override
        public void run() {
            for (int i = 1; i <= n; i++) {
                if (i%2 == 1)
                {
                    try {
                        oddSemaphore.acquire();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(i);
                    zeroSemaphore.release();
                }
            }
        }
    }

    static class Even implements Runnable
    {

        @Override
        public void run() {
            for (int i = 1; i <= n; i++) {
                if (i%2 == 0)
                {
                    try {
                        evenSemaphore.acquire();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(i);
                    zeroSemaphore.release();
                }
            }
        }
    }
}
