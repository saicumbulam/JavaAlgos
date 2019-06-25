package Algorithms.Array;

import java.util.Collections;
import java.util.List;

public class ReArrangeArray {
    public static void rearrange(List<Integer> array){
        for (int i = 1; i < array.size(); i++) {
            if (((i%2) == 0) && (array.get(i-1) < array.get(i)) ||
                    ((i%2) != 0) && (array.get(i-1) > array.get(i))) {
                Collections.swap(array,i-1,i);
            }
        }
    }
}
