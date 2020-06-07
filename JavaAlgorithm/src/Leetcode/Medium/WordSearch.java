package Leetcode.Medium;

public class WordSearch {
    public static void main(String[] args) {
        String word = "ABCCED";
        char[][] board = {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (word.charAt(0) == board[i][j]
                && dfs(word, board, i, j , 0))
                {
                    System.out.println(true);
                    break;
                }
            }
        }
    }


    private static boolean dfs(String word, char[][] board,
                               int r, int c, int count)
    {
        if (count >= word.length())
        {
            return true;
        }

        if (r < 0 || r >= board.length || c < 0
                || c >= board[0].length || board[r][c] != word.charAt(count))
        {
            return false;
        }

        char temp = board[r][c];
        board[r][c] = ' ';
        boolean found = dfs(word, board, r+1, c, count+1)
                || dfs(word, board, r-1, c, count+1)
                || dfs(word, board, r, c+1, count+1)
                || dfs(word, board, r, c-1, count+1);

        board[r][c] = temp;
        return found;
    }
}
