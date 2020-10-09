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

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.List;

public class RemoveInvalidParenthesis {
    static List<String> result = new ArrayList<>();
    public static void main(String[] args) {
        //String str = "()())()";
        String str = "(a)())()";
        //String str = ")(";
        Calculate(str);
        System.out.println(result);
    }

    private static void Calculate(String str)
    {
        Queue<String> queue = new LinkedList<>();
        queue.add(str);
        HashSet<String> set = new HashSet<String>();
        boolean level = false;

        while (!queue.isEmpty())
        {
            String polled = queue.poll();

            if(isValidString(polled))
            {
                result.add(polled);
                System.out.println(polled);
                level = true;
            }

            if(level) continue;

            for (int i = 0; i < polled.length(); i++) {
                if (!isParenthesis(polled.charAt(i)))
                    continue;

                String strs = polled.substring(0,i) + polled.substring(i+1);
                if(!set.contains(strs))
                {
                    set.add(strs);
                    queue.add(strs);
                }
            }
        }
    }

    private static boolean isParenthesis(Character c)
    {
        return ( c == '(') || (c == ')');
    }
    private static boolean isValidString(String str)
    {
        int cnt = 0;
        for (int i = 0; i < str.length(); i++)
        {
            if (str.charAt(i) == '(')
                cnt++;
            else if (str.charAt(i) == ')')
                cnt--;
            if (cnt < 0)
                return false;
        }
        return (cnt == 0);
    }
}
