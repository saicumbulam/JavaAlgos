package Threads.RandomPrograms;

public class ExtendingThread {
    public static void main(String[] args) {
        NewThread newThread = new NewThread();
        newThread.start();
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println("Main thread: " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("Main thread interuppted");
        }

        System.out.println("Main thread exiting");
    }
    static class NewThread extends Thread {
        public NewThread() {
            System.out.println("Child thread created");
        }

        public String GetName()
        {
            return Thread.currentThread().getName();
        }
        @Override
        public void run() {
            System.out.println("Child Thread name: " + GetName());
            try {
                for (int i = 0; i < 10; i++) {
                    System.out.println("child thread: " + i);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                System.out.println("child thread interuppted");
            }

            System.out.println("child thread exiting");
        }
    }
}


