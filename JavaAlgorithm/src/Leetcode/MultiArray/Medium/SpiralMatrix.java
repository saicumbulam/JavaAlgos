//c1, r1+1, c2-1, r2, > r1
package Leetcode.MultiArray.Medium;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] nums = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        System.out.println(Calculate(nums));
    }

    private static List<Integer> Calculate(int[][] nums)
    {
        int r1 = 0, r2 = nums.length-1;
        int c1 = 0, c2 = nums[0].length-1;

        List<Integer> result = new ArrayList<>();

        while (r1 <= r2 && c1 <= c2)
        {
            //c1
            for (int c = c1; c <= c2; c++) {
                result.add(nums[r1][c]);
            }

            //r1+1
            for (int r = r1+1; r <= r2; r++) {
                result.add(nums[r][c2]);
            }

            if (r1 < r2 && c1 < c2)
            {
                //c2-1
                for (int c = c2-1; c > c1; c--) {
                    result.add(nums[r2][c]);
                }

                //r2, > r1
                for (int r = r2; r > r1; r--) {
                    result.add(nums[r][c1]);
                }
            }

            r1++;
            c1++;
            r2--;
            c2--;
        }
        return result;
    }
}
