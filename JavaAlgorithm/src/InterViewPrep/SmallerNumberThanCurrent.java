package InterViewPrep;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class SmallerNumberThanCurrent {
    public static void main(String[] args) {
        int[] nums = {8,1,2,2,3};

        int[] result = Calculate(nums);

        for (int item: result
             ) {
            System.out.println(item);
        }
    }

    private static int[] Calculate(int[] nums)
    {
        HashMap<Integer,Integer> map = new HashMap<>();
        int[] numsClone = nums.clone();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++)
        {
            if (!map.containsKey(nums[i]))
            {
                map.put(nums[i], i);
            }
        }

        for (int i = 0; i < numsClone.length; i++)
        {
            if (map.containsKey(numsClone[i]))
            {
                numsClone[i] = map.get(numsClone[i]);
            }
        }

        return numsClone;
    }
}
