package CrackingCodeInterview;

import java.util.Stack;

public class SortStack {
    public static void main(String[] args) {
        Stack<Integer> r = new Stack<>();
        Stack<Integer> s = new Stack<>();
        while (!s.isEmpty())
        {
            int temp = s.pop();

            while (!r.isEmpty() && r.peek() > temp)
            {
                s.push(r.pop());
            }
            r.push(temp);
        }

        while (!r.isEmpty())
        {
            s.push(r.pop());
        }
    }
}
