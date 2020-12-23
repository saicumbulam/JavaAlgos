package CrackingCodeInterview;

public class MatrixRotate {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println("before rotation");
        displayMatrix(matrix);
        System.out.println("After clockwise rotation");
        FindClockWise(matrix);
        displayMatrix(matrix);
    }

    private static void Find(int[][] matrix) {
        int N = matrix.length;

        // Consider all squares one by one
        for (int x = 0; x < N / 2; x++) {
            // Consider elements in group
            // of 4 in current square

            // top = [x][y]
            // right = [y][N - 1 - x]
            // bottom = [N - 1 - x][N - 1 - y]
            // left = [N - 1 - y][x]

            for (int y = x; y < N - x - 1; y++) {
                // Store current cell in
                // temp variable
                int temp = matrix[x][y];

                // Move values from right to top
                matrix[x][y] = matrix[y][N - 1 - x];

                // Move values from bottom to right
                matrix[y][N - 1 - x] = matrix[N - 1 - x][N - 1 - y];

                // Move values from left to bottom
                matrix[N - 1 - x][N - 1 - y] = matrix[N - 1 - y][x];

                // Assign temp to left
                matrix[N - 1 - y][x] = temp;
            }
        }
    }

    private static void FindClockWise(int[][] matrix) {
        int N = matrix.length;

        // Consider all squares one by one
        for (int x = 0; x < N / 2; x++) {
            // Consider elements in group
            // of 4 in current square

            // top = [x][y]
            // bottom = [N - 1 - x][N - 1 - y]
            // right = [y][N - 1 - x]
            // left = [N - 1 - y][x]

            for (int y = x; y < N - x - 1; y++) {
                // Store current cell in
                // temp variable
                int temp = matrix[x][y];

                matrix[x][y] = matrix[N - 1 - y][x];

                matrix[N - 1 - y][x] = matrix[N - 1 - x][N - 1 - y];

                matrix[N - 1 - x][N - 1 - y] = matrix[y][N - 1 - x];

                matrix[y][N - 1 - x] = temp;
            }
        }
    }


    // Function to print the matrix
    static void displayMatrix(int[][] mat)
    {
        int N = mat.length;;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                System.out.print(" " + mat[i][j]);

            System.out.print("\n");
        }
        System.out.print("\n");
    }
}
