package Algorithms.Array;

import java.util.HashMap;

public class TwoSum {
    private static void findPair(int[] array, int sum) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(sum - array[i])) {
                System.out.println("Pair found at " + map.get(sum-array[i]) + " and  "+ i);
                return;
            }
            map.put(array[i], i);
        }
    }

    public static void main(String[] args) {
        int[] array = {8,7,2,5,3,1};
        int sum = 10;
        findPair(array, sum);
    }


}
