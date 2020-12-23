package CrackingCodeInterview;

public class ZeroMatrix {
    public static void main(String[] args) {
        System.out.println(Find(new int[][]{{1,2,0}, {3,0,0}, {4,0,5}}));
    }

    private static int[][] Find(int[][] matrix)
    {
        boolean isZeroCol = false;
        boolean isZeroRow = false;

        for (int i = 0; i < matrix.length; i++) { //check the first column
            if (matrix[i][0] == 0) {
                isZeroCol = true;
                break;
            }
        }
        for (int i = 0; i < matrix[0].length; i++) { //check the first row
            if (matrix[0][i] == 0) {
                isZeroRow = true;
                break;
            }
        }
        for (int i = 1; i < matrix.length; i++) { //check except the first row and column
            for (int j = 1; j < matrix[0].length; j++)
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
        }
        for (int i = 1; i < matrix.length; i++) { //process except the first row and column
            for (int j = 1; j < matrix[0].length; j++)
                if (matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;
        }
        if (isZeroCol) { //handle the first column
            for (int i = 0; i < matrix.length; i++)
                matrix[i][0] = 0;
        }
        if (isZeroRow) { //handle the first row
            for (int i = 0; i < matrix[0].length; i++)
                matrix[0][i] = 0;
        }

        return matrix;
    }
}
