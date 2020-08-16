/*
Done
* */
package Leetcode.Misc.Medium;

public class TicTacToe {
    static int[] rowCounter;
    static int[] colCounter;
    static int diag;
    static int xdiag;

    public static void main(String[] args) {
        rowCounter = new int[3];
        colCounter = new int[3];
        diag = 0;
        xdiag = 0;
    }

    private static int move(int col, int row ,int player)
    {
        int move = player == 1? 1 : -1;

        rowCounter[row] += move;
        colCounter[col] += move;

        if(row == col)
        {
            diag += move;
        }
        if(row + col == 3-1)
        {
            xdiag += move;
        }

        // math.abs for all values checked.
        if(Math.abs(rowCounter[row]) == 3 ||
                Math.abs(colCounter[col]) == 3 ||
                Math.abs(diag) == 3 || Math.abs(xdiag) == 3)
        {
            return player;
        }
        return 0; //return should be 0 and not -1
    }

}
