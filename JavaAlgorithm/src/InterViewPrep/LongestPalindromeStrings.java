package InterViewPrep;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class LongestPalindromeStrings {
    static int result = 0;
    public static void main(String[] args) {
        //Calculate("(()");
        Calculate(")()())");
        System.out.println(result);
    }

    public static void Calculate(String s) {
        if (s.isEmpty())
        {
            return;
        }
        HashSet<String> set = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(s);
        set.add(s);

        while (!queue.isEmpty())
        {
            String polled = queue.poll();
            if (isValidParenthesis(polled))
            {
                result = Math.max(result, polled.length());
            }
            else {
                for (int i = 0; i < polled.length(); i++) {
                    String temp = polled.substring(0, i) + polled.substring(i + 1);
                    if (!set.contains(temp)) {
                        queue.add(temp);
                        set.add(temp);
                    }
                }
            }
        }
    }

    public static boolean isValidParenthesis(String s)
    {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
            {
                count++;
            }
            if (s.charAt(i) == ')')
            {
                count--;
                if (count < 0)
                {
                    return false;
                }
            }
        }
        return count == 0;
    }
}
