package Leetcode.String.Easy;

public class ReverseOnlyLetters {
    public static void main(String[] args) {
        System.out.println(reverseOnlyLetters("ab-cd"));
    }

    public static String reverseOnlyLetters(String S) {
        char[] chars = S.toCharArray();
        int i = 0;
        int j = S.length()-1;

        while (i < j)
        {
            while (i < j && !Character.isLetter(chars[i]))
            {
                i++;
            }
            while (i < j && !Character.isLetter(chars[j]))
            {
                j--;
            }

            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
            i++;
            j--;
        }

        return String.valueOf(chars);
    }
}
