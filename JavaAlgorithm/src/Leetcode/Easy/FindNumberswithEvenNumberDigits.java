package Leetcode.Easy;

public class FindNumberswithEvenNumberDigits {
    public static void main(String[] args) {
        int[] nums = {12,345,2,6,7896};
        System.out.println(Calculate(nums));
    }

    private static int Calculate(int[] nums)
    {
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            if(IsEvenDigits(nums[i]))
            {
                count++;
            }
        }

        return count;
    }

    private static boolean IsEvenDigits(int num)
    {
        int count = 0;
        while (num != 0)
        {
            count++;
            num = num/10;
        }
        return count % 2 == 0;
    }
}
