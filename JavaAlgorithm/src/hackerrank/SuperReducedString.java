package hackerrank;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class SuperReducedString {
    public static void main(String[] args) {
        System.out.println(Calculate("baab"));
    }

    private static String Calculate(String item)
    {
        Deque<Character> deque = new ArrayDeque<>();
        for (int i = 0; i < item.length(); i++) {
            char c = item.charAt(i);
            if (!deque.isEmpty() && c == deque.getLast())
            {
                deque.removeLast();
                continue;
            }
            deque.addLast(c);
        }

        StringBuilder str = new StringBuilder();
        while (!deque.isEmpty())
        {
            str.append(deque.removeFirst());
        }
        return str.toString();
    }
}
