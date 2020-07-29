package Leetcode.String.Easy.Easy;

public class HappyNumber {
    public static void main(String[] args) {
        int n = 19;
        int slow = n, fast = n;

        do {
            slow = calculate(slow);
            fast = calculate(calculate(fast));
        } while (slow != fast);

        if(slow == 1)
        {
            System.out.println(true);
        }
        else
        {
            System.out.println(false);
        }
    }


    public static int calculate(int num)
    {
        int digit = 0, sum = 0;
        while (num != 0)
        {
            digit = num % 10;
            sum += digit * digit;
            num = num/10;
        }

        return sum;
    }
}
