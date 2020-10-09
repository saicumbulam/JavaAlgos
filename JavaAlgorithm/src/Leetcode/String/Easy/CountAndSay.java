/*
output:
1.     1
2.     11
3.     21
4.     1211
5.     111221
* */
package Leetcode.String.Easy;

public class CountAndSay {
    public static void main(String[] args) {
        int n = 5;
        String result = "1";
        for (int i = 2; i <= n ; i++) {
            String temp = "";
            int j = 0;
            while (j < result.length()) {
                int count = 1;
                while (j < result.length()-1 && result.charAt(j) == result.charAt(j+1))
                {
                    count++;
                    j++;
                }
                temp += String.valueOf(count) + result.charAt(j);
                j++;
            }
            result = temp;
        }

        System.out.println(result);
    }
}
