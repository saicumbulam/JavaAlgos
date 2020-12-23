package InterViewPrep;

import java.util.Stack;

public class RemoveAllAdjacentDuplicatesInStringII {
    public static void main(String[] args) {
        removeDuplicates("eeeaa", 3);
    }

    public static String removeDuplicates(String s, int k) {
        StringBuilder sb = new StringBuilder(s);
        Stack<Integer> counts = new Stack<>();

        for(int i = 0; i < sb.length(); i++)
        {
            if (i == 0 || sb.charAt(i) != sb.charAt(i-1))
            {
                counts.push(1);
            }
            else
            {
                int increment = counts.pop() + 1;
                if (increment == k)
                {
                    sb.delete(i-k+1, i+1);
                    i = i-k;
                }
                else
                {
                    counts.push(increment);
                }
            }
        }

        return sb.toString();
    }
}
