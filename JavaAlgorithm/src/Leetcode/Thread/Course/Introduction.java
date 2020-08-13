package Leetcode.Thread.Course;

/*
Benefits of Threads

1. Higher throughput, though in some pathetic scenarios it is possible to have
the overhead of context switching among threads steal away any throughput
gains and result in worse performance than a single-threaded scenario.
However such cases are unlikely and an exception, rather than the norm.

2. Responsive applications that give the illusion of multi-tasking.

3. Efficient utilization of resources. Note that thread creation is light-weight
in comparison to spawning a brand new process. Web servers that use threads
instead of creating new processes when fielding web requests, consume
far fewer resources.

*/

/*
As a concrete example, consider the example code below.
The task is to compute the sum of all the integers from 0 to Integer.MAX_VALUE.
In the first scenario, we have a single thread doing the summation while
in the second scenario we split the range into two parts and have one thread
sum for each range. In the end, we add the two half sums to get the combined sum.
We measure the time taken for each scenario and print it.
*/
public class Introduction {
    public static void main( String args[] ) throws InterruptedException {
        SumUpExample.runTest();
    }
}

class SumUpExample {

    long startRange;
    long endRange;
    long counter = 0;
    static long MAX_NUM = Integer.MAX_VALUE;

    public SumUpExample(long startRange, long endRange) {
        this.startRange = startRange;
        this.endRange = endRange;
    }

    public void add() {

        for (long i = startRange; i <= endRange; i++) {
            counter += i;
        }
    }

    static public void twoThreads() throws InterruptedException {

        long start = System.currentTimeMillis();
        SumUpExample s1 = new SumUpExample(1, MAX_NUM / 2);
        SumUpExample s2 = new SumUpExample(1 + (MAX_NUM / 2), MAX_NUM);

        Thread t1 = new Thread(() -> {
            s1.add();
        });

        Thread t2 = new Thread(() -> {
            s2.add();
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        long finalCount = s1.counter + s2.counter;
        long end = System.currentTimeMillis();
        System.out.println("Two threads final count = " + finalCount + " took " + (end - start));
    }

    static public void oneThread() {

        long start = System.currentTimeMillis();
        SumUpExample s = new SumUpExample(1, MAX_NUM );
        s.add();
        long end = System.currentTimeMillis();
        System.out.println("Single thread final count = " + s.counter + " took " + (end - start));
    }


    public static void runTest() throws InterruptedException {

        oneThread();
        twoThreads();

    }
}


/* Result of the above code
In my run, I see the two threads scenario run within 652 milliseconds
whereas the single thread scenario runs in 886 milliseconds.
You may observe different numbers but the time taken by two threads
would always be less than the time taken by a single thread.
The performance gains can be many folds depending on the availability
of multiple CPUs and the nature of the problem being solved.
*/


/*
Problems with the threads
1. Usually very hard to find bugs, some that may only rear head in production environments
2. Higher cost of code maintenance since the code inherently becomes harder to reason about
3. Increased utilization of system resources. Creation of each thread consumes additional memory,
    CPU cycles for book-keeping and waste of time in context switches.
4. Programs may experience slowdown as coordination amongst threads comes at a price.
    Acquiring and releasing locks adds to program execution time.
    Threads fighting over acquiring locks cause lock contention.
*/