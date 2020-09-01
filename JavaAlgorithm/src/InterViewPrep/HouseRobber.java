package InterViewPrep;

public class HouseRobber {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        System.out.println(Calculate(nums, 0));
    }

    private static int Calculate(int[] nums, int curr)
    {
        if (curr >= nums.length)
        {
            return 0;
        }

        int take = nums[curr] + Calculate(nums, curr+2);
        int skip = Calculate(nums, curr+1);

        return Math.max(take, skip);
    }
}
