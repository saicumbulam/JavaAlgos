package Leetcode.BinarySearch.Alter;

public class Sqrt {
    public static void main(String[] args) {
        int x = 16;
        System.out.println(Calculate(x));
    }

    private static int Calculate(int target)
    {
        if(target < 2)
        {
            return target;
        }

        int mid = 0;
        int left = 2, right = target/2;
        while (left <= right)
        {
            mid = left+(right - left)/2;
            long num = (long) mid*mid;
            if(num > target)
            {
                right = mid-1;
            }
            else if (num < target)
            {
                left = mid+1;
            }
            else
            {
                return mid;
            }
        }

        return right;
    }
}
