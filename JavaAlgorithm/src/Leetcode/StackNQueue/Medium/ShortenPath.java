package Leetcode.StackNQueue.Medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ShortenPath {
    public static void main(String[] args) {
        String str = "/foo/../test/../test/../foo//bar/./baz";
        System.out.println(Calculate(str));
    }

    private static String Calculate(String str)
    {
        boolean frwdSlash = str.charAt(0) == '/';
        Stack<String> stack = new Stack<>();
        String[] split = str.split("/");
        if (frwdSlash)
        {
            stack.push("");
        }

        for (String item: split
             ) {
            if (item.equals(".."))
            {
                if (stack.isEmpty() || (stack.peek().equals("..")))
                {
                    stack.push(item);
                }
                else if (!stack.peek().equals(""))
                {
                    stack.pop();
                }
            }
            else if (item.equals(".") || item.equals("") )
            {
                continue;
            }
            else
            {
                stack.push(item);
            }
        }
        List<String> result = new ArrayList<>(stack);
        return String.join("/", result);
    }
}
