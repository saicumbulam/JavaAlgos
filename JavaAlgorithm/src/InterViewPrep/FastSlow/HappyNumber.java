/*
Any number will be called a happy number if, after repeatedly replacing
it with a number equal to the sum of the square of all of its digits, leads us to number ‘1’.

Input: 23
Output: true (23 is a happy number)

Time complexity:
Space :
* */
package InterViewPrep.FastSlow;

import java.util.HashSet;

public class HappyNumber {
    public static void main(String[] args) {
        int num = 23;
        System.out.println(Calculate(num));
    }
    static HashSet set = new HashSet<String>();

    private static boolean Calculate(int num)
    {
        int slow = num, fast = num;
        do {
            slow = NextNum(slow);
            fast = NextNum(NextNum(slow));

            if (slow != fast && !set.add(slow) && !set.add(fast))  // avoid inifite loop
            {
                return false;
            }
        } while (slow != fast);

        if (slow == fast && slow == 1)
        {
            return true;
        }
        return false;
    }

    private static int NextNum(int num)
    {
        int digit = 0;
        int sum = 0;

        while ( num != 0)
        {
            digit = num%10;
            sum += digit*digit;
            num = num/10;
        }
        return sum;
    }
}
