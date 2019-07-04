package Algorithms.Search;

import java.util.List;

public class SearchEntryEqualtoIndex {
    public int SearchEntry(List<Integer> array){
        int left = 0, right = array.size() - 1;
        while (left <= right){
            int mid = left + (right - left)/2;
            int diffrence = array.get(mid) - mid;

            if (diffrence == 0) {
                return mid;
            } else if(diffrence > 0){
                right = mid -1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
