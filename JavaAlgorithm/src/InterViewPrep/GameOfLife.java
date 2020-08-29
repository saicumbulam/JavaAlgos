package InterViewPrep;

public class GameOfLife {
    public static void main(String[] args) {
        int[][] arr = {
                {0, 1, 0},
                {0, 0, 1},
                {1, 1, 1},
                {0, 0, 0}
        };

        int[][] result = Calculate(arr);

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j] + ", ");
            }
            System.out.println();
        }
    }


    private static int[][] Calculate(int[][] arr)
    {
        int[] neighbors = {0,-1,1};

        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[0].length; col++) {

                int liveNeihbor = 0;

                for (int i = 0; i < neighbors.length; i++) {
                    for (int j = 0; j < neighbors.length; j++) {
                        if(!(neighbors[i] == 0 && neighbors[j] == 0))
                        {
                            int r = neighbors[i] + row;
                            int c = neighbors[j] + col;

                            if (r >= 0 && r < arr.length && c >= 0
                                    && c < arr[0].length && Math.abs(arr[r][c]) == 1)
                            {
                                liveNeihbor++;
                            }

                        }
                    }
                }

                if (arr[row][col] == 1 && (liveNeihbor < 2 || liveNeihbor > 3))
                {
                    arr[row][col] = -1;
                }
                else if (arr[row][col] == 0 && liveNeihbor == 3)
                {
                    arr[row][col] = 2;
                }
            }
        }


        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if(arr[i][j] > 0)
                {
                    arr[i][j] = 1;
                }
                else
                {
                    arr[i][j] = 0;
                }
            }
        }

        return arr;
    }
}
