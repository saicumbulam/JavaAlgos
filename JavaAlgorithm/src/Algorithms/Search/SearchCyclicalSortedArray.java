package Algorithms.Search;

import java.util.List;

public class SearchCyclicalSortedArray {
    public int searchSmallest(List<Integer> array){
        int left = 0, right = array.size() - 1;
        while (left < right){
            int mid = left + (right-left)/2;

            if (array.get(mid) > array.get(right)) {
                // Minimum must be in array sublist (mid+1, right +1)
                left = mid+1;
            } else {
                // minimum must be sublist (mid+1, right+1) so it must be in sublist (left,mid+1)
                right = mid;
            }
        }
        // loop ends when left == right
        return left;
    }
}
