/*
1. Iterate the row and the col of the matrix
2. if the row,col is zero then continue.
3. else, check the neighbouring columns and add the visited array if n is found.
4. if already there is a 1, then increment result.
* */
package Leetcode.MultiArray.Medium;

public class CountCornerRectangles {
    public static void main(String[] args) {
        //int[][] grid = {{1, 0, 0, 1, 0}, {0, 0, 1, 0, 1}, {0, 0, 0, 1, 0}, {1, 0, 1, 0, 1}};
        int[][] grid = {{1, 0, 1}, {1, 0, 1}, {0, 0, 0}};
        System.out.println(countCornerRectangles(grid));
    }

    public static int countCornerRectangles(int[][] grid) {
        if(grid.length == 0) return 0;
        int[][] visited = new int[grid[0].length][grid[0].length];
        int result = 0;
        for(int row = 0; row < grid.length; row++){
            for(int col = 0; col < grid[0].length; col++){
                if(grid[row][col] == 0) continue;
                for(int colEnd = col + 1; colEnd < grid[0].length; colEnd++){
                    if(grid[row][colEnd] == 0) continue;
                    result += visited[col][colEnd];
                    visited[col][colEnd]++;
                }
            }
        }
        return result;
    }
}
