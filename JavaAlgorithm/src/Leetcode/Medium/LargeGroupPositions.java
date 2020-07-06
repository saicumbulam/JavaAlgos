package Leetcode.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargeGroupPositions {
    public static void main(String[] args) {
        String str = "abbxxxxzzy";
        System.out.println(Calculate(str));
    }

    private static List<List<Integer>> Calculate(String str)
    {
        List<List<Integer>> result = new ArrayList<>();
        int i = 0;

        for (int j = 0; j < str.length(); j++) {
            if (j == str.length()-1|| str.charAt(j) != str.charAt(j+1))
            {
                if (j-i+1 >= 3)
                {
                    result.add(Arrays.asList(i, j));
                }
                i = j+1;
            }
        }

        return result;
    }
}
