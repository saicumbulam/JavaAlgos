/*
A robot is located at the top-left corner of a m x n grid
(marked 'Start' in the diagram below).

The robot can only move either down or right at
any point in time. The robot is trying to reach the
bottom-right corner of the grid (marked 'Finish' in the diagram below).

Now consider if some obstacles are added to the grids.
How many unique paths would there be?
* */
package Leetcode.Dynamic.Alter;

public class UniquePaths2 {
    public static void main(String[] args) {
        int[][] arr = {{0,0,0},{0,1,0},{0,0,0}};
        System.out.println(Calc(arr));
    }

    private static int Calc(int[][] arr)
    {
        if(arr[0][0] == 1) return 0;

        arr[0][0] = 1;

        // Filling the values for the first column
        for (int i = 1; i < arr.length; i++) {
            arr[i][0] = (arr[i][0] == 0 && arr[i - 1][0] == 1) ? 1 : 0;
        }

        // Filling the values for the first row
        for (int i = 1; i < arr[0].length; i++) {
            arr[0][i] = (arr[0][i] == 0 && arr[0][i - 1] == 1) ? 1 : 0;
        }

        // i.e. From above and left.
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr[0].length; j++) {
                if (arr[i][j] == 0) {
                    arr[i][j] = arr[i - 1][j] + arr[i][j - 1];
                } else {
                    arr[i][j] = 0;
                }
            }
        }

        // Return value stored in rightmost bottommost cell. That is the destination.
        return arr[arr.length - 1][arr[0].length - 1];
    }
}
