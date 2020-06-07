package Legacy.Algorithms.Heaps;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SortApproximatelySortedData {
    public List<Integer> sortApproximaltelyData(Iterator<Integer> sequence, int k){
        PriorityQueue<Integer> minheap = new PriorityQueue<>();

        for (int i = 0; i < k && sequence.hasNext(); i++) {
            minheap.add(sequence.next());
        }

        List<Integer> result = new ArrayList<>();

        // For every new element, add it to minheap and extract smallest

        while(sequence.hasNext()){
            minheap.add(sequence.next());
            Integer smallest = minheap.remove();
            result.add(smallest);
        }

        //sequence is exhauseted, iteratively extracts other elements
        result.addAll(Stream.generate(minheap:: remove).limit(minheap.size()).collect(Collectors.toList()));
        return result;
    }
}
