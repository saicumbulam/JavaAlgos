package Leetcode.Easy;

public class Reverse {
    public static void main(String[] args) {
        int x = -123;

        int rev = 0;

        while (x != 0)
        {
            int pop = x % 10;
            x = x/10;

            if(rev > Integer.MAX_VALUE ||
                    (rev == Integer.MAX_VALUE && pop > 7))
            {
                System.out.println(0);
                break;
            }

            if(rev < Integer.MIN_VALUE ||
                    (rev == Integer.MIN_VALUE && pop < -8))
            {
                System.out.println(0);
                break;
            }

            rev = rev*10 + pop;
        }

        System.out.println(rev);
    }
}
