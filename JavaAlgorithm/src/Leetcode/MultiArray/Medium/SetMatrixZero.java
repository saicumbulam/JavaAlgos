package Leetcode.MultiArray.Medium;

import java.util.ArrayList;
import java.util.List;

public class SetMatrixZero {
    public static void main(String[] args) {
        int[][] nums = {{1,1,1}, {1,0,1}, {1,1,1}};

        List<Integer> rows = new ArrayList<>();
        List<Integer> cols = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums[0].length; j++) {
                if(nums[i][j] == 0)
                {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }

        for (int item: rows
             ) {
            for (int i = 0; i < nums[0].length; i++) {
                nums[item][i] = 0;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            for (int item: cols
                 ) {
                nums[i][item] = 0;
            }
        }


        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                System.out.println(nums[i][j]);
            }
        }
    }
}
