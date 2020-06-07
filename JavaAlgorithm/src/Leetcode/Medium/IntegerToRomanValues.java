package Leetcode.Medium;

public class IntegerToRomanValues {
    public static void main(String[] args) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int x = 4;

        String result = "";

        for (int i = 0; i < values.length; i++) {
            while (values[i] <= x)
            {
                result += symbols[i];
                x -= values[i];
            }
        }

        System.out.println(result);
    }
}
