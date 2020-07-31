package Leetcode.MultiArray.Medium;

public class LongestIncreasingPathMatrix {
    public static void main(String[] args) {
        int[][] arr = new int[][]{{9, 9, 4}, {6, 6, 8}, {2, 1, 1}};
        System.out.println(Calculate(arr));
    }

    private static int Calculate(int[][] arr) {
        int max = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                max = Math.max(max, dfs(arr, i, j, -1));
            }
        }

        return max;
    }

    private static int dfs(int[][] arr, int r, int c, int prev) {
        //0,0
        int[][] neighbors = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        if (r < 0 || r >= arr.length || c < 0 || c >= arr[0].length) {
            return Integer.MIN_VALUE;
        }

        int res = 0;

        for (int i = 0; i < neighbors.length; i++) {
            int row = r + neighbors[i][0];
            int col = c + neighbors[i][1];
            if (row < 0 || row >= arr.length || col < 0 || col >= arr[0].length) {
                continue;
            }
            if (prev == -1 || arr[row][col] > prev) {
                int cal = dfs(arr, row, col, arr[row][col]);
                if (cal != Integer.MIN_VALUE) {
                    res += 1;
                }
            }
        }
        return res;
    }
}
