package Leetcode.Easy;

public class AddStrings {
    public static void main(String[] args) {
        String str1 = "0";
        String str2 = "0";

        System.out.println(Calculate(str1, str2));
    }

    public static String Calculate(String num1, String num2) {
        StringBuilder result = new StringBuilder();

        int i = num1.length()-1;
        int j = num2.length()-1;
        int sum = 0;
        int carry = 0;

        while (i >= 0 || j >= 0)
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

            if(sum > 9)
            {
                result.insert(0,String.valueOf(sum%10));
                carry = sum/10;
            }
            else
            {
                result.insert(0,sum);
                carry = 0;
            }

        }

        if (carry > 0)
        {
            result.insert(0,String.valueOf(carry));
        }

        return result.toString();
    }
}
