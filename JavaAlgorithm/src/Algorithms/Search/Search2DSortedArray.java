package Algorithms.Search;

import java.util.List;

public class Search2DSortedArray {
    public boolean matrixSearch(List<List<Integer>> array, int x){
        int row = 0, col = array.get(0).size() - 1;
        // keeps searching while there are unclassified rows and cols
        while (row < array.size() && col >= 0){
            if (array.get(row).get(col).equals(x)) {
                return true;
            } else if (array.get(row).get(col) < x) {
                row++;
            } else {
                col--;
            }
        }
        return false;
    }
}
