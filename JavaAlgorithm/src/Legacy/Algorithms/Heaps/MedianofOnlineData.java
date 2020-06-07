package Legacy.Algorithms.Heaps;

import java.util.*;

public class MedianofOnlineData {
    private int DEFAULT_INTIAL_CAPACITY=16;

    private List<Double> onlineMedian(Iterator<Integer> sequence){
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(DEFAULT_INTIAL_CAPACITY, Collections.reverseOrder());

        List<Double> result = new ArrayList<>();

        while (sequence.hasNext()){
            int x = sequence.next();
            minHeap.add(x);
            maxHeap.add(minHeap.remove());

            // ensure minheap should always be more or equal to maxheap
            if(maxHeap.size() > minHeap.size()){
                minHeap.add(maxHeap.remove());
            }

            result.add((minHeap.size() == maxHeap.size() ? 0.5 * (minHeap.peek() + maxHeap.peek()):
                    (double) minHeap.peek()));
        }
        return result;
    }
}
