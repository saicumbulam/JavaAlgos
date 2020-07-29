package Leetcode.String.Easy.Easy;

public class SameColorPixel {
    public static void main(String[] args) {
        //int[][] arr = {{1,1,1},{1,1,0},{1,0,1}};
        int[][] arr = {{0,0,0},{0,1,1}};
        //int sr = 1, sc = 1, newColor = 2;
        int sr = 1, sc = 1, newColor = 1;
        Calculate(arr, sr, sc, newColor);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.println(arr[i][j]);
            }
        }
    }

    private static void Calculate(int[][] arr, int sr, int sc, int newColor)
    {
        if (sr >= arr.length || sc >= arr[0].length)
        {
            return;
        }

        int oldColor = arr[sr][sc];
        if (oldColor == newColor)   // this condition is important to avoid inifte loop
        {
            return;
        }
        Dfs(arr, sr, sc, oldColor, newColor);
    }

    private static void Dfs(int[][] arr, int r, int c, int oldColor, int newColor) {
        if (r >= arr.length || r < 0 || c >= arr[0].length || c < 0 || arr[r][c] != oldColor)
        {
            return;
        }

        arr[r][c] = newColor;
        Dfs(arr, r+1, c, oldColor, newColor);
        Dfs(arr, r-1, c, oldColor, newColor);
        Dfs(arr, r, c+1, oldColor, newColor);
        Dfs(arr, r, c-1, oldColor, newColor);
    }
}
