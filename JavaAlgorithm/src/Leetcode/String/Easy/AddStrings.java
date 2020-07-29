package Leetcode.String.Easy;

public class AddStrings {
    public static void main(String[] args) {
        String str1 = "10";
        String str2 = "11";

        System.out.println(Calculate(str1, str2));
    }

    public static String Calculate(String num1, String num2) {
        StringBuilder result = new StringBuilder();

        int i = num1.length()-1;
        int j = num2.length()-1;
        int sum = 0;
        int carry = 0;

        while (i >= 0 || j >= 0 || carry > 0)
        {
            sum = carry;
            if (i >= 0)
            {
                sum += Character.getNumericValue(num1.charAt(i--));
            }
            if (j >= 0)
            {
                sum += Character.getNumericValue(num2.charAt(j--));
            }

            result.insert(0,String.valueOf(sum%10));
            carry = sum/10;

        }

        return result.toString();
    }
}
