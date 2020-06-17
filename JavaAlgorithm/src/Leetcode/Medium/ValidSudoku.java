package Leetcode.Medium;

import java.util.HashSet;

public class  ValidSudoku {
    public static void main(String[] args) {
        String[][] board = {
                {"5", "3", ".", ".", "7", ".", ".", ".", "."},
                {"6", ".", ".", "1", "9", "5", ".", ".", "."},
                {".", "9", "8", ".", ".", ".", ".", "6", "."},
                {"8", ".", ".", ".", "6", ".", ".", ".", "3"},
                {"4", ".", ".", "8", ".", "3", ".", ".", "1"},
                {"7", ".", ".", ".", "2", ".", ".", ".", "6"},
                {".", "6", ".", ".", ".", ".", "2", "8", "."},
                {".", ".", ".", "4", "1", "9", ".", ".", "5"},
                {".", ".", ".", ".", "8", ".", ".", "7", "9"}};

        System.out.println(Calculate(board));
    }

    private static boolean Calculate(String[][] board)
    {
        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != ".")
                {
                    if (!set.add(board[i][j] + " row: " + i)
                            || !set.add(board[i][j] + " col: " + j) ||
                            !set.add(board[i][j] + " row: " + i/3 + " col: " + j/3 ))
                    {
                        return false;
                    }
                }

            }
        }
        return true;
    }
}
