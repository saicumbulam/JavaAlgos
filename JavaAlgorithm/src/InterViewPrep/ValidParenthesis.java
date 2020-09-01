package InterViewPrep;

import java.util.Stack;

public class ValidParenthesis {
    public static void main(String[] args) {
        String str =  "()[]{}";
        System.out.println(Calculate(str));
    }

    private static boolean Calculate(String str)
    {
        Stack<Character> stack = new Stack<>();

        for (char c: str.toCharArray()
             ) {
            if (c == ')' || c == ']' || c == '}')
            {
                if(stack.isEmpty())
                {
                    return false;
                }
                if ((c == ')' && stack.pop() != '(') ||
                        (c == ']' && stack.pop() != '[') ||
                        (c == '}' && stack.pop() != '{'))
                {
                    return false;
                }
            }
            else
            {
                stack.push(c);
            }
        }

        if (!stack.isEmpty()) return false;
        return true;
    }
}
