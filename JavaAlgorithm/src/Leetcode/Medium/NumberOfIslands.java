package Leetcode.Medium;

public class NumberOfIslands {
    public static void main(String[] args) {
        char[][] arr = {{'1','1','1','1','0'},
        {'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};

        System.out.println(Calculate(arr));
    }

    private static int Calculate(char[][] arr)
    {
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if(arr[i][j] == '1')
                {
                    count += dfs(arr, i, j);
                }
            }
        }
        return count;
    }

    private static int dfs(char[][] arr, int r, int c)
    {
        if(r < 0 || r >= arr.length || c < 0 || c > arr[0].length || arr[r][c] == '0')
        {
            return 0;
        }

        arr[r][c] = '0';
        dfs(arr, r+1, c);
        dfs(arr, r-1, c);
        dfs(arr, r, c+1);
        dfs(arr, r, c-1);
        return 1;
    }
}
