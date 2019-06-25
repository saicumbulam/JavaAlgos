package Algorithms.Array;

public class SetMatrixZeroes {
    private static void setZeroes(int[][] mat){
        boolean firstRow = false;
        boolean firstCol = false;

        // set firstrow and fistcolumn zero
        for (int i = 0; i < mat.length; i++) {
            if (mat[i][0] == 0) {
                firstCol = true;
                break;
            }
        }

        for (int i = 0; i < mat[0].length ; i++) {
            if (mat[0][i] == 0) {
                firstRow = true;
                break;
            }
        }
        // mark zeros on first row and first col
        for (int i = 1; i <mat.length ; i++) {
            for (int j = 1; j <mat[0].length ; j++) {
                if (mat[i][j] == 0) {
                    mat[i][0] = 0;
                    mat[0][j] = 0;
                }
            }
        }

        // use mark to set elements
        for (int i = 1; i < mat.length; i++) {
            for (int j = 1; j < mat[0].length; j++) {
                if (mat[i][0] == 0 || mat[0][j] == 0) {
                    mat[i][j] = 0;
                }
            }
        }

        if (firstCol) {
            for (int i = 0; i <mat.length ; i++) {
                mat[i][0] = 0;
            }
        }

        if (firstRow) {
            for (int i = 0; i <mat[0].length ; i++) {
                mat[0][i] = 0;
            }
        }


    }

    private static void display(int[][] mat){
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length ; j++) {
                System.out.println(" " + mat[i][j]);
            }
            System.out.println("\n");
        }
        System.out.println("\n");
    }

    public static void main(String[] args) {
        int mat[][] = {
                {1,1,1,0},
                {1,1,1,0},
                {1,1,0,0},
                {1,0,0,0}
        };

        setZeroes(mat);
        display(mat);
    }
}
