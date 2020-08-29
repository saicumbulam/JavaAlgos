package InterViewPrep;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestDistanceCharacter {
    public static void main(String[] args) {
        String s = "loveleetcode";
        Character c = 'e';
        int[] result = Calculate(s, c);
        for (int item: result
             ) {
            System.out.println(item);
        }
    }

    private static int[] Calculate(String str, Character c)
    {
        int[] ans = new int[str.length()];
        Queue<Integer> queue = new LinkedList<>();
        int pre = -1;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == c)
            {
                queue.add(i);
            }
        }

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != c)
            {
                if(!queue.isEmpty())
                {
                    if (pre != -1)
                    {
                        ans[i] = Math.min(queue.peek()-i, i - pre); //Math.min(future, previous index)
                    }
                    else {
                        ans[i] = queue.peek()-i;  // future index
                    }
                }
                else
                {
                    ans[i] = i - pre;
                }
            }
            else
            {
                ans[i] = 0;
                pre = i;
                queue.poll(); // poll future index
            }
        }
        return ans;
    }
}
