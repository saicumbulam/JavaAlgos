package Leetcode.MultiArray.Medium;

import java.util.ArrayList;
import java.util.List;

public class DiagonalTraverse {
    public static void main(String[] args) {
        int[][] arr = {
                {1,3,4,10},
                {2,5,9,11},
                {6,8,12,15},
                {7,13,14,16}
        };
        System.out.println(Calculate(arr));
    }

    private static List<Integer> Calculate(int[][] arr)
    {
        List<Integer> result = new ArrayList<>();

        int m = arr.length-1;
        int n = arr[0].length-1;
        int r = 0;
        int c = 0;
        boolean goingDown = true;

        while (!(r < 0 || r > m || c < 0 || c > n))
        {
            result.add(arr[r][c]);
            if (goingDown)
            {
                if (c == 0 || r == m)
                {
                    goingDown = false;
                    if (r == m)
                    {
                        c++;
                    }
                    else
                    {
                        r++;
                    }
                }
                else
                {
                    r++;
                    c--;
                }
            }
            else
            {
                if (c == n || r == 0)
                {
                    goingDown = true;
                    if (c == n)
                    {
                        r++;
                    }
                    else
                    {
                        c++;
                    }
                }
                else
                {
                    r--;
                    c++;
                }
            }
        }

        return result;
    }
}
