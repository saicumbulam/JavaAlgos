package Leetcode.String.Easy;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] arr = {"flower","flow","flight"};
        System.out.println(Calculate(arr));
    }

    private static String Calculate(String[] arr) {
        int index = 0;
        StringBuilder result = new StringBuilder();

        for (char c: arr[0].toCharArray()
             ) {
            for (int i = 1; i < arr.length; i++) {
                if (index >= arr[i].length() || c != arr[i].charAt(index))
                {
                    return result.toString();
                }
            }
            index++;
            result.append(c);
        }

        return result.toString();
    }
}
