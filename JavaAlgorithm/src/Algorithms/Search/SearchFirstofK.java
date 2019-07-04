package Algorithms.Search;

import java.util.List;

public class SearchFirstofK {
    public int searchFirstofK(List<Integer> array, int k){
        int left = 0, right = array.size()-1, result = -1;

        while (left <= right){
            int mid = left + (right - left)/2;
            if (array.get(mid) > k) {
                right = mid -1;
            } else if(array.get(mid) == k){
                result = mid;

                //Nothing can be the right of the mid be the first occurence of k
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        return result;
    }
}
