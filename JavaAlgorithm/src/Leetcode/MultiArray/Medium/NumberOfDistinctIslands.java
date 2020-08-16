/*
Half done
* */
package Leetcode.MultiArray.Medium;

import java.util.HashSet;
import java.util.StringJoiner;

public class NumberOfDistinctIslands {
    public static void main(String[] args) {
        int[][] arr = {
                {1,1,0,0,0},
                {1,1,0,0,0},
                {0,0,0,1,1},
                {0,0,0,1,1}
        };

        int[][] arr2 = {
                {1,1,0,1,1},
                {1,0,0,0,0},
                {0,0,0,0,1},
                {1,1,0,1,1}
        };
        int[][] arr3 = {
                {1,1,0},
                {0,1,1},
                {0,0,0},
                {1,1,1},
                {0,1,0}};
        System.out.println(Calculate(arr));

    }

    private static int Calculate(int[][] arr)
    {
        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == 1)
                {
                    String result = Dfs(arr, i, j, "center");
                    if (!set.contains(result))
                    {
                        set.add(result);
                    }
                }
            }
        }

        return set.size();
    }

    private static String Dfs(int[][] arr, int r, int c, String ops) {
        StringJoiner result = new StringJoiner("->");
        if(r < 0 || r >= arr.length || c <0 || c >= arr[0].length || arr[r][c] == 0)
        {
            return "";
        }

        result.add(ops);
        arr[r][c] = 0;

        String up = Dfs(arr, r+1, c, "down");
        String down = Dfs(arr, r-1, c, "up");
        String right = Dfs(arr, r, c+1, "right");
        String left = Dfs(arr, r, c-1, "left");

        if (!right.equals(""))
        {
            result.add(right);
        }
        if (!left.equals(""))
        {
            result.add(left);
        }

        if (!up.equals(""))
        {
            result.add(up);
        }

        if (!down.equals(""))
        {
            result.add(down);
        }

        return result.toString();
    }
}
