package Leetcode.Subsets.Hard;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class UniqueGeneralizedAbbrevation {
    static class AbbrWord
    {
        StringBuilder str;
        int start;
        int count;

        public AbbrWord(StringBuilder str, int start,int count)
        {
            this.str = str;
            this.start = start;
            this.count = count;
        }
    }

    public static void main(String[] args) {
        String str = "BAT";
        System.out.println(Calculate(str));
    }

    private static List<String> Calculate(String str)
    {
        List<String> result = new ArrayList<>();
        Queue<AbbrWord> queue = new LinkedList<>();
        queue.add(new AbbrWord(new StringBuilder(), 0, 0));
        while (!queue.isEmpty())
        {
            AbbrWord polled = queue.poll();
            if(polled.start >= str.length())
            {
                if(polled.count != 0)
                {
                    polled.str.append(polled.count);
                }
                result.add(polled.str.toString());
            }
            else
            {
                // continue abbreviating
                queue.add(new AbbrWord(new StringBuilder(polled.str),
                        polled.start+1,
                        polled.count+1));

                // restart abbreviating
                if(polled.count != 0)
                {
                    polled.str.append(polled.count);
                }
                queue.add(new AbbrWord(
                        new StringBuilder(polled.str).append(str.charAt(polled.start)),
                        polled.start+1, 0));
            }
        }

        return result;
    }
}
