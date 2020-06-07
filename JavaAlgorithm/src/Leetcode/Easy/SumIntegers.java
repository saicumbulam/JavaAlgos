package Leetcode.Easy;

public class SumIntegers {
    public static void main(String[] args) {
        int a = 3, b = 4;

        while (b != 0)
        {
            int carry = a & b; // and operation for carry
            a = a ^ b; // first number is xor of two numbers
            b = carry << 1; // second number is left shift of carry
        }

        System.out.println(a);
    }
}
