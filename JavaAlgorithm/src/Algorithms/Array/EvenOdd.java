package Algorithms.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class EvenOdd {
    public static List<Integer> evenOdd(List<Integer> array){
        int nextEven = 0, nextOdd = array.size() - 1;
        while (nextEven < nextOdd){
            if (array.get(nextEven)%2 ==0) {
                nextEven++;
            } else {
                Collections.swap(array, nextEven, nextOdd--);
            }
        }
        return array;
    }

    public static void main(String[] args) {
        System.out.println(evenOdd(Arrays.asList(1,2,3,4,5,6,7,8,9)));
    }
}
