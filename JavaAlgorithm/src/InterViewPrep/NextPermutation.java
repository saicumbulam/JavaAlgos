package InterViewPrep;

public class NextPermutation {
    public static void main(String[] args) {
        nextPermutation(new int[]{1,2,3});
    }

    public static void nextPermutation(int[] nums) {
        int i = nums.length-2;

        while(i >= 0 && nums[i] >= nums[i+1])
        {
            i--;
        }

        if (i >= 0)
        {
            int j = nums.length-1;

            while(j >= 0 && nums[j] <= nums[i])
            {
                j--;
            }
            swap(nums, i, j);
        }
        Reverse(nums,i+1, nums.length-1);
    }

    private static void Reverse(int[] nums, int start, int end)
    {
        while(start < end)
        {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    private static void swap(int[] nums, int i, int j)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
