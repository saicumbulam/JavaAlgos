package Leetcode.Easy;

public class ImplementStrStr {
    public static void main(String[] args) {
        String haystack = "hello", needle = "ll";

        int windowStart = 0;

        StringBuilder temp = new StringBuilder();

        for (int windowEnd = 0; windowEnd < haystack.length();
             windowEnd++) {

            temp.append(haystack.charAt(windowEnd));

            if(windowEnd >= needle.length()-1)
            {
                if(temp.toString().equals(needle))
                {
                    System.out.println(windowStart);
                }
                windowStart++;
                temp .deleteCharAt(0);
            }
        }
        System.out.println(-1);
    }
}
