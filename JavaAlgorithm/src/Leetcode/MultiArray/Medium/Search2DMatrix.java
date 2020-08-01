package Leetcode.MultiArray.Medium;

import java.util.PriorityQueue;

public class Search2DMatrix {
    public static void main(String[] args) {
        int[][] nums = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };

        int target = 5;

        int row = 0, col = nums.length-1;

        while (row < nums.length && col >= 0)
        {
            if (nums[row][col] == target)
            {
                System.out.println("Found");
                break;
            }

            if(nums[row][col] > target)
            {
                col--;
            }
            else
            {
                row++;
            }
        }
    }

    ;
}
