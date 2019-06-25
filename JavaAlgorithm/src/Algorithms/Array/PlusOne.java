package Algorithms.Array;

import java.util.Arrays;
import java.util.List;

public class PlusOne {
    public static List<Integer> plusone(List<Integer> array){
        int n = array.size() - 1;
        array.set(n, array.get(n) + 1);

        for (int i = n; i > 0 && array.get(i) == 10 ; --i) {
            array.set(i, 0);
            array.set(i -1, array.get(i-1) + 1);
        }

        if (array.get(0) == 10) {
            array.set(0, 1);
            array.add(0);
        }
        return array;
    }

    public static void main(String[] args) {
        System.out.println(plusone(Arrays.asList(1, 2, 3)));
    }
}
