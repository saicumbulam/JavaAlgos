package Leetcode.MultiArray.Medium;

public class WallsGates {
    public static void main(String[] args) {
        int[][] arr = {{Integer.MAX_VALUE,-1,0,Integer.MAX_VALUE},
                {Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,-1},
                {Integer.MAX_VALUE,-1,Integer.MAX_VALUE,-1},
                {0,-1,Integer.MAX_VALUE,Integer.MAX_VALUE}};
        Calculate(arr);

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.println(arr[i][j]);
            }
        }
    }


    private static void Calculate(int[][] arr)
    {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i][j] == 0)
                {
                    Dfs(arr, i, j, 0);
                }
            }
        }
    }

    private static void Dfs(int[][] arr, int i, int j, int count)
    {

        if (i < 0 || i >= arr.length || j < 0 || j >= arr[0].length || arr[i][j] < count) // this is smarter way to avoid walls and gates
        {
            return;
        }

        arr[i][j] = count;
        Dfs(arr, i+1, j, count+1);
        Dfs(arr, i-1, j, count+1);
        Dfs(arr, i, j+1, count+1);
        Dfs(arr, i, j-1, count+1);
    }
}
