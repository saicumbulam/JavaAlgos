package InterViewPrep;

public class RangeSumQuery2D {
    public static void main(String[] args) {
        int[][] matrix = {
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}};

        System.out.println(Calculate(matrix, 2, 1, 4, 3));
    }

    private static int Calculate(int[][] arr, int row1, int col1, int row2, int col2) {

        int[][] dp = new int[arr.length][arr[0].length+1];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                dp[i][j+1] = dp[i][j] + arr[i][j];
            }
        }


        int sum = 0;
        for (int r = row1; r <= row2; r++) {
            sum += dp[r][col2+1] - dp[r][col1];
        }
        return sum;
    }


}
