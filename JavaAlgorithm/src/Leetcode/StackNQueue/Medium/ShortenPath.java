package Leetcode.StackNQueue.Medium;

import java.util.*;

public class ShortenPath {
    public static void main(String[] args) {
        String str = "/foo/../test/../test/../foo//bar/./baz"; ///foo/bar/baz
        System.out.println(Calculate(str));
    }

    private static String Calculate(String str)
    {
        boolean isFwdSLash = str.charAt(0) == '/';

        String[] split;
        if(isFwdSLash)
        {
            split = str.substring(1).split("/");
        }
        else
        {
            split = str.split("/");
        }

        Stack<String> stack = new Stack<>();

        for (int i = 0; i < split.length; i++) {
            if(split[i].equals(".") || split[i].equals(""))
            {
                continue;
            }
            else if (split[i].equals(".."))
            {
                stack.pop();
            }
            else
            {
                stack.push(split[i]);
            }
        }

        Collections.reverse(stack);
        StringJoiner stringBuilder = new StringJoiner("/");
        while (!stack.isEmpty())
        {
            stringBuilder.add(stack.pop());
        }
        if(isFwdSLash) return "/" + stringBuilder.toString();
        return stringBuilder.toString();
    }
}
