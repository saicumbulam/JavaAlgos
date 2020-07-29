package Leetcode.String.Easy;

import javax.print.attribute.standard.Compression;

public class StringCompression {
    public static void main(String[] args) {
        //char[] charArr = new char[]{'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        //char[] charArr = new char[]{'a'};
        //char[] charArr = new char[]{'a','b','b','b','b','b','b','b','b','b','b','b','b'};
        char[] charArr = new char[]{'a','a','a','b','b','a','a'};
        int index = compress(charArr);

        System.out.println("index: " + index);

        for (int i = 0; i < index; i++) {
            System.out.println(charArr[i]);
        }
    }

    public static int compress(char[] chars) {
        int write = 0, read = 0;

        while (read < chars.length) {
            int count = 1;

            while (read < chars.length - 1 && chars[read] == chars[read + 1]) {
                count++;
                read++;
            }

            if (count > 1)
            {
                chars[write++] = chars[read];
                for (char c: String.valueOf(count).toCharArray()) {
                    chars[write++] = c;
                }
            }
            else
            {
                chars[write++] = chars[read];
            }
            read++;
        }

        return write;
    }
}
