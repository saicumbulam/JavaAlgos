package Leetcode.Easy;

public class GcdTwoNumbers {
    public static void main(String[] args) {
        int num1 = 55, num2 = 121;
        while (num1 != num2)
        {
            if (num1 > num2)
            {
                num1 -= num2;
            }
            else
            {
                num2 -= num1;
            }
        }

        System.out.println(num1);
    }
}
