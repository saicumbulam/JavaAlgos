package Leetcode.Medium;

import java.util.LinkedList;

public class RemoveKDigits {
    public static void main(String[] args) {
        String num = "1432219";
        int k = 3;
        System.out.println(Calculate(num, k));
    }

    public static String Calculate(String num, int k) {

        LinkedList<Character> list = new LinkedList<>();

        for (char c: num.toCharArray())
        {
            while (!list.isEmpty() && k > 0 && list.peekLast() > c)
            {
                list.removeLast();
                k--;
            }
            list.addLast(c);
        }

        while (k > 0)
        {
            list.removeLast();
            k--;
        }

        boolean leadingZero = true;
        StringBuilder result = new StringBuilder();
        for (char item : list)
        {
            if (leadingZero && item == '0')
            {
                continue;
            }
            else
            {
                leadingZero = false;
                result.append(item);
            }
        }

        if (result.length() == 0)
        {
            return "0";
        }

        return result.toString();
    }
}
