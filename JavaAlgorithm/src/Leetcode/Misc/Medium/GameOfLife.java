package Leetcode.Misc.Medium;

public class GameOfLife {
    public static void main(String[] args) {
        int[] neighbors = {0, -1, 1};
        int[][] input = {{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}};
        for (int row = 0; row < input.length; row++) {
            for (int col = 0; col < input[0].length; col++) {
                int liveNeighbors = 0;
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (!(neighbors[i] == 0 && neighbors[j] == 0)) {
                            int r = row + neighbors[i];
                            int c = col + neighbors[j];

                            if (r >= 0 &&
                                    r < input.length &&
                                    c >= 0 &&
                                    c < input[0].length && Math.abs(input[r][c]) == 1) {
                                liveNeighbors += 1;
                            }
                        }
                    }
                }

                if (input[row][col] == 1 && (liveNeighbors < 2 || liveNeighbors > 3)) {
                    input[row][col] = -1;
                }
                else if (input[row][col] == 0 && (liveNeighbors == 3)) {
                    input[row][col] = 2;
                }
            }
        }

        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[0].length; j++) {
                if (input[i][j] > 0) {
                    input[i][j] = 1;
                } else {
                    input[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[0].length; j++) {
                System.out.println(input[i][j]);
            }
        }
    }
}
