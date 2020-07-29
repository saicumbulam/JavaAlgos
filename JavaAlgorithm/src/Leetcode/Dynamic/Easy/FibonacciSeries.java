package Leetcode.Dynamic.Easy;

public class FibonacciSeries {
    public static void main(String[] args) {
        System.out.println("5th Fibonacci is ---> " + CalculateFibonacci(5));
    }

    private static int CalculateFibonacci(int num) {
        if (num < 2)
        {
            return num;
        }

        return CalculateFibonacci(num-1) + CalculateFibonacci(num-2);
    }
}
