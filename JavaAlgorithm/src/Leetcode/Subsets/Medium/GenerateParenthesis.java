package Leetcode.Subsets.Medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GenerateParenthesis {
    public static void main(String[] args) {
        int n = 3;
        System.out.println(Calculate(n));
    }

    private static List<String> Calculate(int n)
    {
        List<String> result = new ArrayList<>();
        Queue<Paren> queue = new LinkedList<>();
        queue.add(new Paren("",0,0));

        while (!queue.isEmpty())
        {
            Paren polled = queue.poll();
            if(polled.start == n && polled.end == n)
            {
                result.add(polled.str);
            }
            else
            {
                if(polled.start < n)
                {
                    queue.add(new Paren(polled.str + '(',polled.start+1,polled.end));
                }
                if(polled.start > polled.end)
                {
                    queue.add(new Paren(polled.str + ')',polled.start,polled.end+1));
                }
            }
        }

        return result;
    }
}

class Paren {
    String str;
    int start;
    int end;

    public Paren(String str, int start, int end) {
        this.str = str;
        this.start = start;
        this.end = end;
    }
}
