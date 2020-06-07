package Legacy.Algorithms.Stack;

import java.util.ArrayDeque;
import java.util.EmptyStackException;
import java.util.Queue;

public class StackUsingQueues {
    class StackUsingQueuecls{
        Queue<Integer> queue1 = new ArrayDeque<Integer>();
        Queue<Integer> queue2 = new ArrayDeque<Integer>();

        void push(int data){
            queue1.add(data);
        }

        boolean isEmpty(){
            return queue1.size() + queue2.size() == 0;
        }

        int pop(){
            if(isEmpty()){
                throw new EmptyStackException();
            }
            while (queue1.size() > 1){
                queue2.add(queue1.remove());
            }

            int value = queue1.remove();

            swap_queues();
            return value;
        }

        void swap_queues(){
            Queue<Integer> queue3 = new ArrayDeque<Integer>();
            queue1 = queue2;
            queue2 = queue3;
        }

    }
    public static void main(String[] args) {
        StackUsingQueues sqc = new StackUsingQueues();
        StackUsingQueues.StackUsingQueuecls sq = sqc.new StackUsingQueuecls();

        sq.push(1);
        sq.push(2);

        System.out.println(sq.pop());

        sq.push(3);
        System.out.println(sq.pop());


    }
}
