package InterViewPrep;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] result = Calculate(nums, k);
        for (int item: result
             ) {
            System.out.println(item);
        }
    }


    private static int[] Calculate(int[] nums, int k)
    {
        int[] result = new int[nums.length-k+1];
        List<Integer> window = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            window.add(nums[i]);

            if(i-k+1 >= 0)
            {
                int max = 0;
                for (int item: window
                     ) {
                    max = Math.max(max, item);
                }
                result[i-k+1] = max;
                window.remove(0);
            }
        }

        return result;
    }
}
