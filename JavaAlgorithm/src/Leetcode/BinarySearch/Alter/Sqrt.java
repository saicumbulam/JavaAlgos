package Leetcode.BinarySearch.Alter;

public class Sqrt {
    public static void main(String[] args) {
        int x = 16;
        System.out.println(Calculate(x));
    }

    private static int Calculate(int x)
    {
        if(x < 2)
        {
            return x;
        }

        int pivot = 0;
        int left = 2, right = x/2;
        while (left <= right)
        {
            pivot = left+(right - left)/2;
            long num = (long) pivot*pivot;
            if(num > x)
            {
                right = pivot-1;
            }
            else if (num < x)
            {
                left = pivot+1;
            }
            else
            {
                return pivot;
            }
        }

        return right;
    }
}
