package InterViewPrep;

public class ShortestPathGridObstaclesElimination {
    public static void main(String[] args) {
        int[][] arr = {
                {0,0,0},
                {1,1,0},
                {0,0,0},
                {0,1,1},
                {0,0,0}};
        int k = 1;
        System.out.println(Calculate(arr, k));
    }

    private static int Calculate(int[][] arr, int k)
    {
        int count = 0;
        count = Math.min(count, Dfs(arr, 0, 0));
        return count;
    }

    private static int Dfs(int[][] arr, int r, int c)
    {
        if (r < 0 || r >= arr.length ||
                c < 0 || c >= arr[0].length ||
                arr[r][c] == 1 || arr[r][c] == -1)
        {
            return 0;
        }
        int count = 1;
        arr[r][c] = -1;
        count += Dfs(arr, r+1, c);
        count += Dfs(arr, r-1, c);
        count += Dfs(arr, r, c+1);
        count += Dfs(arr, r, c-1);
        return count;

    }
}
