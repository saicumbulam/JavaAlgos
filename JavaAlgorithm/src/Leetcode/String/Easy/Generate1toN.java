package Leetcode.String.Easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Generate1toN {
    public static void main(String[] args) {
        System.out.println(Calculate(4));
    }

    private static List<String> Calculate(int n)
    {
        List<String> result = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();
        // this should be 1
        queue.add("1");

        for (int i = 0; i < n; i++) {
            String item = queue.poll();
            result.add(item);
            String s1 = item + "0";
            String s2 = item + "1";
            queue.add(s1);
            queue.add(s2);
        }

        return result;
    }
}
