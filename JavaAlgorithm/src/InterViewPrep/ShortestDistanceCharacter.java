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
        int[] result = new int[str.length()];
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == c) queue.add(i);
        }
        int previous = -1;

        for (int i = 0; i < str.length(); i++) {
            if(c != str.charAt(i))
            {
                if(!queue.isEmpty())
                {
                    if (previous != -1)
                    {
                        result[i] = Math.min(queue.peek()-i, i - previous); //Math.min(future, previous index)
                    }
                    else {
                        result[i] = queue.peek()-i;  // future index
                    }
                }
                else
                {
                    result[i] = i - previous;
                }
            }
            else
            {
                result[i] = 0;
                previous = i;
                queue.poll();
            }
        }

        return result;
    }
}
