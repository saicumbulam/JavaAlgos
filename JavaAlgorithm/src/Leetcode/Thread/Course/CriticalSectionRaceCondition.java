package Leetcode.Thread.Course;


/*
Critical Section:
Critical section is any piece of code that has the possibility of
being executed concurrently by more than one thread of the application
and exposes any shared data or resources used by the application for access.


Race Condition:
Race conditions happen when threads run through critical sections without thread synchronization.
The threads "race" through the critical section to write or read shared resources
and depending on the order in which threads finish the "race", the program output changes.
*/

import java.util.Random;

public class CriticalSectionRaceCondition {
    public static void main(String args[]) throws InterruptedException {
        RaceCondition.runTest();
    }
}

class RaceCondition {

    int randInt;
    Random random = new Random(System.currentTimeMillis());

    void printer() {

        int i = 1000000;
        while (i != 0) {
            if (randInt % 5 == 0) {
                if (randInt % 5 != 0)
                    System.out.println(randInt);
            }
            i--;
        }
    }

    void modifier() {

        int i = 1000000;
        while (i != 0) {
            randInt = random.nextInt(1000);
            i--;
        }
    }

    public static void runTest() throws InterruptedException {


        final RaceCondition rc = new RaceCondition();
        Thread thread1 = new Thread(new Runnable() {

            @Override
            public void run() {
                rc.printer();
            }
        });
        Thread thread2 = new Thread(new Runnable() {

            @Override
            public void run() {
                rc.modifier();
            }
        });


        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
    }
}


/*
The above program spawns two threads.
One thread prints the value of a shared variable whenever the shared variable is divisible by 5.
A race condition happens when the printer thread executes a test-then-act if clause,
which checks if the shared variable is divisible by 5 but before the thread can print the variable out,
its value is changed by the modifier thread.
Some of the printed values aren't divisible by 5 which verifies
the existence of a race condition in the code.
*/