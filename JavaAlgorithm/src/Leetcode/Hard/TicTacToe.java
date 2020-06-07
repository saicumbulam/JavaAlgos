package Leetcode.Hard;

public class TicTacToe {
    int[] rowCounter;
    int[] colCounter;
    int xdiag;
    int diag;
    int n;

    public TicTacToe(int n) {
        this.n = n;
        rowCounter = new int[n];
        colCounter = new int[n];
    }

    public int move(int row, int col, int player) {
        int move = player == 1 ? 1 : -1;
        rowCounter[row] += move;
        colCounter[col] += move;

        if (row == col)
        {
            diag += move;
        }

        if (row + col == n-1)
        {
            xdiag += move;
        }

        if (Math.abs(rowCounter[row]) == n || Math.abs(colCounter[row]) == n ||
                Math.abs(diag) == n || Math.abs(xdiag) == n)
        {
            return player;
        }
        return 0;
    }

}
