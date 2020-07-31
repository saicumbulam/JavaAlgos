package Leetcode.MultiArray.Easy;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    public static void main(String[] args) {
        int n = 5;
        List<List<Integer>> result = Calculate(n);
        System.out.println(result);
    }

    public static List<List<Integer>> Calculate(int n)
    {
        List<List<Integer>> result = new ArrayList<>();
        if (n == 0)
        {
            return result;
        }

        result.add(new ArrayList<>());
        result.get(0).add(1);

        for (int i = 1; i < n; i++) {
            List<Integer> curr = new ArrayList<>();
            List<Integer> prev = result.get(i-1);

            curr.add(1);

            for (int j = 1; j < prev.size(); j++) {
                curr.add(prev.get(j-1) + prev.get(j));
            }
            curr.add(1);

            result.add(curr);
        }

        return result;
    }
}
