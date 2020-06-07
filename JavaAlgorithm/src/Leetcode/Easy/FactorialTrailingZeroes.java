package Leetcode.Easy;

public class FactorialTrailingZeroes {
    public static void main(String[] args) {
        int n = 5;
        int currentMultiple = 5;
        int zeroCount = 0;

        while (n >= currentMultiple)
        {
            zeroCount += n/currentMultiple;
            currentMultiple *= 5;
        }
        System.out.println(zeroCount);
    }
}
