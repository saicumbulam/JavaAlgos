package Legacy.Algorithms.Search;

import java.util.List;

public class BinarySearch {
    private int bSearch(int i, List<Integer> array){
        int L =0, U = array.size()-1;
        while (L <= U){
            int M =  L + (U-L)/2;
            if (array.get(M) == i) {
                return M;
            } else if (array.get(M) < i){
                L = M + 1;
            } else {
                U = M-1;
            }

        }
        return -1;
    }
}
