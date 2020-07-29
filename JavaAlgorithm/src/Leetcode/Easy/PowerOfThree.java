package Leetcode.String.Easy.Easy;

public class PowerOfThree {
    public static void main(String[] args) {
        int n = 27;

        while (n % 3 == 0)
        {
            n = n/3;
        }

        if (n == 1)
        {
            System.out.println(true);
        }
        else
        {
            System.out.println(false);
        }

    }
}
