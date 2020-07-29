package Leetcode.BitWise.Easy;

public class NumberOf1Bits {
    public static void main(String[] args) {
        int n = 00000000000000000000000000001011;

        int count = 0;

        while (n != 0)
        {
            n &= (n-1);
            count++;
        }

        System.out.println(count);
    }
}
