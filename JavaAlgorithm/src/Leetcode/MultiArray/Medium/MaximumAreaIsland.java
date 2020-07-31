package Leetcode.MultiArray.Medium;

public class MaximumAreaIsland {
    public static void main(String[] args) {
        int[][] arr = {{0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}};

        System.out.println(Calculate(arr));
    }

    private static int Calculate(int[][] arr)
    {
        int max = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i][j] == 1)
                {
                    max = Math.max(max, Dfs(arr, i, j));
                }
            }
        }
        return max;
    }

    private static int Dfs(int[][] arr, int r, int c)
    {
        if (r < 0 || r >= arr.length || c < 0 || c >= arr[0].length || arr[r][c] == 0)
        {
            return 0;
        }

        arr[r][c] = 0;
        int count = 1;
        count += Dfs(arr, r+1,c);
        count += Dfs(arr, r-1,c);
        count += Dfs(arr, r,c+1);
        count += Dfs(arr, r,c-1);
        return count;
    }
}
