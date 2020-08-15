package Leetcode.MultiArray.Medium;

public class RottingOranges {
    private static int[][] neigh = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    private static int count = 0;

    public static void main(String[] args) {
        //int[][] arr = {{2,1,1},{1,1,0},{0,1,1}};
        //int[][] arr = {{1,1,2,0,2,0}};
        //int[][] arr = {{2, 1, 1}, {0, 1, 1}, {1, 0, 1}};
        int[][] arr = {{1,2,1,1,2,1,1}};
        //int[][] arr = {{1,2}};
        System.out.println(Calculate(arr));
    }

    private static int Calculate(int[][] grid) {

        while (Iterator(grid))
        {
        }


        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }

        return count;
    }

    private static boolean Iterator(int[][] grid)
    {
        boolean flag = false;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    if (Calculate(grid, i, j)) {
                        flag = true;
                        count++;
                    }
                }
            }
        }
        return flag;
    }

    private static boolean Calculate(int[][] grid, int r, int c) {
        boolean flag = false;

        for (int i = 0; i < neigh.length; i++) {
            int row = r + neigh[i][0];
            int col = c + neigh[i][1];

            if (row == 2 && col == 0) {
                System.out.println();
            }
            if (row >= 0 && row < grid.length
                    && col >= 0 && col < grid[0].length
                    && grid[row][col] != 2 && grid[row][col] != 0) {
                if (flag == false) {
                    flag = true;
                }
                grid[row][col] = 2;
            }
        }

        return flag;
    }
}
