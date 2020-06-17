package Threads.Course;

public class BlockingQueue {
    public static void main( String args[] ) throws Exception{
        final BlockQueue<Integer> q = new BlockQueue<Integer>(5);

        Thread t1 = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    for (int i = 0; i < 50; i++) {
                        q.enqueue(i);
                        System.out.println("enqueued " + i);
                    }
                } catch (InterruptedException ie) {

                }
            }
        });

        Thread t2 = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    for (int i = 0; i < 25; i++) {
                        System.out.println("Thread 2 dequeued: " + q.dequeue());
                    }
                } catch (InterruptedException ie) {

                }
            }
        });

        Thread t3 = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    for (int i = 0; i < 25; i++) {
                        System.out.println("Thread 3 dequeued: " + q.dequeue());
                    }
                } catch (InterruptedException ie) {

                }
            }
        });

        t1.start();
//        Thread.sleep(4000);
//        t2.start();
//
//        t2.join(); // the join will complete and after that the next statement are executed
//
//        t3.start();
        t1.join();
//        t3.join();
    }

    // The blocking queue class
    static class BlockQueue<T> {

        T[] array;
        Object lock = new Object();
        int size = 0;
        int capacity;
        int head = 0;
        int tail = 0;

        @SuppressWarnings("unchecked")
        public BlockQueue(int capacity) {
            // The casting results in a warning
            array = (T[]) new Object[capacity];
            this.capacity = capacity;
        }

        public void enqueue(T item) throws InterruptedException {

            synchronized (lock) {

                while (size == capacity) {
                    lock.wait();
                }

                if (tail == capacity) {
                    tail = 0;
                }

                array[tail] = item;
                size++;
                tail++;
                lock.notifyAll();
            }
        }

        public T dequeue() throws InterruptedException {

            T item = null;
            synchronized (lock) {

                while (size == 0) {
                    lock.wait();
                }

                if (head == capacity) {
                    head = 0;
                }

                item = array[head];
                array[head] = null;
                head++;
                size--;
                lock.notifyAll();
            }

            return item;
        }
    }

}

