package Leetcode.Easy;

public class ReverseInteger {
    public static void main(String[] args) {
        int num = -123;
        System.out.println(Calculate(num));
    }

    private static int Calculate(int num)
    {
        // no need to read the negative value, because getting the modulo itself will get the negative
        int pivot = 0;

        while (num != 0) // != is the result of doing digit seperation
        {
            int digit = num %10;
            num = num/10;
            if (pivot > Integer.MAX_VALUE/10 ||
                    (pivot == Integer.MAX_VALUE/10 && digit > 7 ))
            {
                return 0;
            }
            if (pivot < Integer.MIN_VALUE/10 ||
                    (pivot == Integer.MIN_VALUE/10 && digit < -8 ))
            {
                return 0;
            }

            pivot = pivot*10 + digit;
        }
        return (int) pivot;
    }
}
