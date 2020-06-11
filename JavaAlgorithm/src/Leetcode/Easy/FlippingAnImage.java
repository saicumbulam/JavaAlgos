package Leetcode.Easy;

public class FlippingAnImage {
    public static void main(String[] args) {
        //int[][] matrix = {{1,1,0},{1,0,1},{0,0,0}};
        int[][] matrix = {{1,1,0,0},{1,0,0,1},{0,1,1,1},{1,0,1,0}};
        Calculate(matrix);
        PrintMatrix(matrix);
    }

    private static void PrintMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

    private static void Calculate(int[][] matrix)
    {
        if (matrix.length == 0 || matrix[0].length == 0)
        {
            return;
        }

        for (int i = 0; i < matrix.length; i++) {
            int start = 0, end = matrix[0].length-1;
            while (start < end)
            {
                int temp = matrix[i][start];
                matrix[i][start] =  matrix[i][end];
                matrix[i][end] = temp;
                start++;
                end--;
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1)
                {
                    matrix[i][j] = 0;
                }
                else
                {
                    matrix[i][j] = 1;
                }
            }
        }
    }
}
