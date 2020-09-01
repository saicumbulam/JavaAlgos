package Leetcode.Misc.Easy;

public class FactorialTrailingZeroes {
    public static void main(String[] args) {
        int n = 5;
        System.out.println(Calculate(n));
    }

    private static int Calculate(int n)
    {
        int count = 0;
        int multiple = 5;   // this should be long to avoid Integer max value error

        while (n >= multiple){
            count += n/multiple;
            multiple *= 5;
        }

        return count;
    }
}
