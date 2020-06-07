package Legacy.Algorithms.Heaps;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class KLargestElementsMaxHeap {
    private int DEFAULT_INITIAL_ACTIVITY = 16;

    private class HeapEntry {
        public Integer index;
        public Integer value;

        public HeapEntry(Integer index, Integer value) {
            this.index = index;
            this.value = value;
        }
    }

    public List<Integer> kLargestBinaryHeap(List<Integer> array, int k){
        if (k <= 0) {
            return Collections.EMPTY_LIST;
        }

        PriorityQueue<HeapEntry> candidateMaxHeap = new PriorityQueue<>(DEFAULT_INITIAL_ACTIVITY,
                (o1,o2) -> Integer.compare(o1.value,o2.value));

        candidateMaxHeap.add(new HeapEntry(0, array.get(0)));

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            Integer candidateIdx = candidateMaxHeap.peek().index;
            result.add(candidateMaxHeap.remove().value);

            Integer leftChildIdx = 2*candidateIdx + 1;
            if (leftChildIdx < array.size()) {
                candidateMaxHeap.add(new HeapEntry(leftChildIdx, array.get(leftChildIdx)));
            }

            Integer rightChildIdx = 2*candidateIdx + 2;
            if (rightChildIdx < array.size()) {
                candidateMaxHeap.add(new HeapEntry(rightChildIdx, array.get(rightChildIdx)));
            }
        }
        return result;
    }

}
