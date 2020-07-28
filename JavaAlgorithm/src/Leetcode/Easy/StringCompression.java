package Leetcode.Easy;

public class StringCompression {
    public static void main(String[] args) {
        System.out.println(new char[]{'a','a','b','b','c','c','c'});
    }

    public static int compress(char[] chars) {
        int index = 0;
        int i = 0;

        while (i < chars.length)
        {
            int j = i;

            while (j < chars.length && chars[i] == chars[j])
            {
                j++;
            }

            chars[index++] = chars[i];

            if (j-i > 1)
            {
                String count = String.valueOf(j-i);
                for (char c : count.toCharArray())
                {
                    chars[index++] = c;
                }

            }

            i = j;
        }

        return index;
    }
}
