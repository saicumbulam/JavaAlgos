package Leetcode.String.Easy.Easy;

public class ReverseAString {
    public static void main(String[] args) {
        System.out.println(Reverse("Hello World"));
    }

    public static String Reverse(String str)
    {
        char[] strArray = str.toCharArray();
        int start = 0, end = str.length()-1;
        while (start < end)
        {
            char temp = strArray[start];
            strArray[start] = strArray[end];
            strArray[end] = temp;
            start++;
            end--;
        }

        return String.valueOf(strArray);
    }
}
