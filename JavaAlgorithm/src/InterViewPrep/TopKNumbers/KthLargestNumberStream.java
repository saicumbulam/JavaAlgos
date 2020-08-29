package InterViewPrep.TopKNumbers;

import java.util.PriorityQueue;

public class KthLargestNumberStream {
    static PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    static int k;

    public static void main(String[] args) {
        int[] arr = {3, 1, 5, 12, 2, 11};
        int k = 4;
        Calculate(arr, k);

        System.out.println(add(6));
        System.out.println(add(13));
        System.out.println(add(4));
    }
    private static void Calculate(int[] arr, int k)
    {
        for (int item: arr
             ) {
            minHeap.add(item);
            if(minHeap.size() > k)
            {
                minHeap.poll();
            }
        }
    }
    private static int add(int val)
    {
        minHeap.add(val);
        if(minHeap.size() > k)
        {
            minHeap.poll();
        }
        
        return minHeap.peek();
    }
}
