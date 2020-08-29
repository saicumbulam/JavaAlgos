/*
As we need to generate all possible output we will backtrack
among all states by removing one opening or closing bracket
and check if they are valid if invalid then add the removed
bracket back and go for next state. We will use BFS for moving through states,
use of BFS will assure removal of minimal number of brackets because we traverse
into states level by level and each level corresponds to one extra bracket removal.
Other than this BFS involve no recursion so overhead of passing parameters is also saved.
* */
package InterViewPrep;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class RemoveInvalidParenthesis {
    public static void main(String[] args) {
        //String str = "()())()";
        //String str = "(a)())()";
        String str = ")(";
        Calculate(str);
    }

    private static void Calculate(String str)
    {
        Queue<String> queue = new LinkedList<>();
        boolean level = false;
        HashSet<String> set = new HashSet<>();
        queue.add(str);
        set.add(str);

        while(!queue.isEmpty())
        {
            String polled = queue.poll();
            if (isValidString(polled))
            {
                System.out.println(polled);
                level = true;
            }
            if (level)
                continue;

            for (int i = 0; i < str.length(); i++) {
                if (!isParenthesis(str.charAt(i)))
                {
                    continue;
                }

                String temp = str.substring(0,i) + str.substring(i+1); // remove the current parenthesis
                if (!set.contains(temp))
                {
                    queue.add(temp);
                    set.add(temp);
                }
            }

        }
    }

    private static boolean isValidString(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(')
            {
                count++;
            }
            else if (str.charAt(i) == ')')
            {
                count--;
            }
            //This condition is important to ignore ()())( brackets
            if (count < 0)
            {
                return false;
            }
        }

        return count == 0;
    }

    private static boolean isParenthesis(char c)
    {
        return c == ')' || c == '(';
    }
}
