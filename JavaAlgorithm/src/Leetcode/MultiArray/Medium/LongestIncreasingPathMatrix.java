package Leetcode.MultiArray.Medium;

public class LongestIncreasingPathMatrix {
    private static final int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private static int m, n;

    public static void main(String[] args) {
        int[][] arr = new int[][]{{9, 9, 4}, {6, 6, 8}, {2, 1, 1}};
        //int[][] arr = new int[][]{{3,4,5}, {3,2,6}, {2, 2, 1}};
        //int[][] arr = new int[][]{{1}};
        System.out.println(Calculate(arr));
    }

    private static int Calculate(int[][] arr) {
        int max = 0;
        m = arr.length;
        n = arr[0].length;
        int[][] cache = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(max, dfs(arr, i, j, cache));
            }
        }

         return max;
    }

    private static int dfs(int[][] arr,  int i, int j, int[][] cache) {
        if (cache[i][j] != 0) return cache[i][j];
        for (int[] d : dirs) {
            int x = i + d[0], y = j + d[1];
            if (0 <= x && x < m && 0 <= y && y < n && arr[x][y] > arr[i][j])
                cache[i][j] = Math.max(cache[i][j], dfs(arr, x, y, cache));
        }
        return ++cache[i][j];
    }
}
