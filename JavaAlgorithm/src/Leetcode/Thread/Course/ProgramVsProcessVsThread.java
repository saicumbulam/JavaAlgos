package Leetcode.Thread.Course;


/*
Program:
A program is a set of instructions and associated data that resides on the disk
and is loaded by the operating system to perform some task.
An executable file or a python script file are examples of programs.
In order to run a program, the operating system's kernel is first asked to create a new process,
which is an environment in which a program executes.
*/

/*
Process:
A process is a program in execution. A process is an execution environment that consists of instructions,
user-data, and system-data segments,
as well as lots of other resources such as CPU,
memory, address-space, disk and network I/O acquired at runtime.
*/

/*
Threads:
Thread is the smallest unit of execution in a process.
A thread simply executes instructions serially.
A process can have multiple threads running as part of it.
The globally shared state amongst the threads of a process
is visible and accessible to all the threads, and special attention needs to be paid
when any thread tries to read or write to this global shared state.
*/

import java.util.Random;

public class ProgramVsProcessVsThread {
    // We'll use this to randomly sleep our threads
    static Random random = new Random(System.currentTimeMillis());

    public static void main(String args[]) throws InterruptedException {

        // create object of unsafe counter
        ThreadUnsafeCounter badCounter = new ThreadUnsafeCounter();

        // setup thread1 to increment the badCounter 200 times
        Thread thread1 = new Thread(new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    badCounter.increment();
                    sleepRandomlyForLessThan10Secs();
                }
            }
        });

        // setup thread2 to decrement the badCounter 200 times
        Thread thread2 = new Thread(new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    badCounter.decrement();
                    sleepRandomlyForLessThan10Secs();
                }
            }
        });

        // run both threads
        thread1.start();
        thread2.start();

        // wait for t1 and t2 to complete.
        thread1.join();
        thread2.join();

        // print final value of counter
        badCounter.printFinalCounterValue();
    }

    public static void sleepRandomlyForLessThan10Secs() {
        try {
            Thread.sleep(random.nextInt(10));
        } catch (InterruptedException ie) {
        }
    }
}

class ThreadUnsafeCounter {

    int count = 0;

    public void increment() {
        count++;
    }

    public void decrement() {
        count--;
    }

    void printFinalCounterValue() {
        System.out.println("counter is: " + count);
    }
}


/*
The above program is a thread unsafe program

The final value of the counter should be zero,
however, if you run the program enough times,
you'll sometimes get the correct zero value,
and at others, you'll get a non-zero value
* */