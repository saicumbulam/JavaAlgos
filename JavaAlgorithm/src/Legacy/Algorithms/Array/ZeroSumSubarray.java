package Legacy.Algorithms.Array;

import java.util.HashSet;
import java.util.Set;

public class ZeroSumSubarray {
    public static void main(String[] args) {
        int[] array = {4,-6,3,-1,4,2,7};
        if (zeroSum(array)) {
            System.out.println("subarray exists");
        } else {
            System.out.println("subarray not exists");
        }
    }

    private static boolean zeroSum(int[] array) {
        Set<Integer> set = new HashSet<>();

        set.add(0);
        int sum = 0;

        for (int i = 0; i < array.length; i++) {
            sum += array[i];

            // if sum is seen before we have a sub array of 0
            if (set.contains(sum)) {
                return true;
            }
            set.add(sum);
        }
        return false;
    }
}
