import java.util.Arrays;
import java.util.HashMap;

public class HowMuchNumbersSmallerthanCurrent {
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
        int[] result = nums.clone();
        Arrays.sort(result);

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < result.length; i++
             ) {
            if (!map.containsKey(result[i])) {
                map.put(result[i], i);
            }
        }


        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]))
            {
                nums[i] = map.get(nums[i]);
            }
        }

        return nums;
    }
}
