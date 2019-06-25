package Algorithms.Heaps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortKIncreasingDecreasingArray {
    private enum SubArrayType {INCREASING, DECREASING};
    private SetofSortedSequence setofSortedSequence = new SetofSortedSequence();

    public List<String> sortKIncreasingDecreasingArray(List<Integer> array) {
        List<List<Integer>> sortedSubArrays = new ArrayList<>();

        SubArrayType subArrayType = SubArrayType.INCREASING;

        int startIdx = 0;

        for (int i = 0; i <= array.size(); i++) {
            if (i == array.size() ||
                    (array.get(i-1) < array.get(i) && subArrayType == SubArrayType.DECREASING) ||
                    (array.get(i-1) >= array.get(i) && subArrayType == SubArrayType.INCREASING)) {

                List<Integer> sublist = array.subList(startIdx, i);
                if (subArrayType == SubArrayType.DECREASING) {
                    Collections.reverse(sublist);
                }
                sortedSubArrays.add(sublist);
                startIdx = i;
                subArrayType = (subArrayType == SubArrayType.INCREASING ?
                        SubArrayType.DECREASING : SubArrayType.INCREASING);
            }
        }
        return setofSortedSequence.mergeKSortedArray(sortedSubArrays);
    }
}
