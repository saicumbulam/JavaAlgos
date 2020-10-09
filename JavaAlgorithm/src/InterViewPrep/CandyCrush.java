package InterViewPrep;

public class CandyCrush {
    public static void main(String[] args) {
        int[][] arr = {{110,5,112,113,114},
                {210,211,5,213,214},{310,311,3,313,314},{410,411,412,5,414},
        {5,1,512,3,3},{610,4,1,613,614},{710,1,2,713,714},{810,1,2,1,1},{1,1,2,2,2},{4,1,4,4,1014}};
        System.out.println(Calculate(arr));
    }

    public static int[][] Calculate(int[][] board) {
        while(readyToCrash(board)){
            crash(board);
            gravity(board);
        }
        return board;
    }

    public static boolean readyToCrash(int[][] board) {
        boolean isReadyToCrash = false;
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length - 2; j++){
                if(Math.abs(board[i][j]) != 0 && Math.abs(board[i][j]) == Math.abs(board[i][j + 1])
                        && Math.abs(board[i][j]) == Math.abs(board[i][j + 2])){
                    isReadyToCrash = true;
                    int flag = -Math.abs(board[i][j]);
                    board[i][j] = flag;
                    board[i][j + 1] = flag;
                    board[i][j + 2] = flag;
                }
            }
        }
        for(int i = 0; i < board[0].length; i++) {
            for(int j = 0; j < board.length - 2; j++){
                if(Math.abs(board[j][i]) != 0 && Math.abs(board[j][i]) == Math.abs(board[j + 1][i])
                        && Math.abs(board[j][i]) == Math.abs(board[j + 2][i])){
                    isReadyToCrash = true;
                    int flag = -Math.abs(board[j][i]);
                    board[j][i] = flag;
                    board[j + 1][i] = flag;
                    board[j + 2][i] = flag;
                }
            }
        }
        return isReadyToCrash;
    }

    public static void crash(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] < 0) {
                    board[i][j] = 0;
                }
            }
        }
    }

    public static void gravity(int[][] board){
        //iterate thru the each column wise and from the bottom of the row
        for(int i = 0; i < board[0].length; i++) {
            int count = board.length - 1;
            for(int j = board.length - 1; j >= 0; j--){
                if(board[j][i] != 0){
                    board[count][i] = board[j][i];
                    count--;
                }
            }
            while (count >= 0)
                board[count--][i] = 0;
        }
    }
}
