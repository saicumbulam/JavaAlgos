package Leetcode.Easy;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] arr = {"flower","flow","flight"};
        System.out.println(Calculator(arr));
    }

    private static String Calculator(String[] arr) {
        StringBuilder result = new StringBuilder();
        int index = 0;

        for (char c : arr[0].toCharArray()) {
            for (int i = 1; i < arr.length; i++) {
                if(index >= arr[i].length() || c != arr[i].charAt(index))
                {
                    return result.toString();
                }
            }
            index++;
            result.append(String.valueOf(c));
        }
        return null;
    }
}
