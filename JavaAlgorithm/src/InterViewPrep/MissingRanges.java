package InterViewPrep;

import java.util.ArrayList;
import java.util.List;

public class MissingRanges {
    public static void main(String[] args) {
        int[] nums = {0, 1, 3, 50, 75};
        int lower = 0;
        int upper = 99;

        List<String> output = Calculate(nums, lower, upper);
        System.out.println(output);
    }

    private static List<String> Calculate(int[] nums, int lower, int upper)
    {
        List<String> list = new ArrayList<>();
        if (nums.length == 0)
        {
            if (lower == upper)
            {
                list.add(String.format("%d",lower));
            }
            else
            {
                list.add(String.format("%d->%d",lower,upper));
            }

            return list;
        }

        int counter = lower;
        int i = 0;

        while (i < nums.length) {
            if (nums[i] == counter)
            {
                counter++;
                i++;
            }
            else
            {
                if (i <= nums.length-1 && nums[i] == counter+1)
                {
                    list.add(String.format("%d",counter));
                    counter = nums[i];
                }
                else if (i <= nums.length-1)
                {
                    list.add(String.format("%d->%d",counter, nums[i]-1));
                    counter = nums[i];
                }
            }
        }
        if (nums[nums.length-1] != lower)
        {
            list.add(String.format("%d->%d",nums[nums.length-1]+1, upper));
        }
        return list;
    }
}
