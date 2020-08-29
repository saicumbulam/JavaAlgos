package InterViewPrep;

public class MaximalRectangle {
    public static void main(String[] args) {
        String[][] arr = {
                {"1","0","1","0","0"},
                {"1","0","1","1","1"},
                {"1","1","1","1","1"},
                {"1","0","0","1","0"}
        };
        System.out.println(Calculate(arr));
    }

    private static int Calculate(String[][] arr)
    {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j].equals("1"))
                {
                    count = Math.max(count, Dfs(arr, i, j,0));
                }
            }
        }
        return count;
    }

    private static int Dfs(String[][] arr, int r, int c, int count)
    {
        if(r < 0 || r >= arr.length || c < 0 || c >= arr[0].length)
        {
            return 0;
        }

        int max = 0;

        int newCol = c;
        int newRow = r+1;
        while (newCol < arr[0].length) {
            if (arr[r][newCol].equals("1"))
            {
                max++;
            }
            if (newCol == arr[0].length-1)
            {
                break;
            }
            else if (arr[r][newCol].equals("0"))
            {
                break;
            }
            newCol++;
        }

        if (newCol == c+1 || newCol >= arr[0].length)
        {
            return 0;
        }

        if(newRow >= arr.length)
        {
            return 0;
        }

        for (int i = c; i <= newCol; i++) {
            if (arr[newRow][i].equals("1"))
            {
                max++;
            }
            else
            {
                return 0;
            }
        }

        return max;
    }
}
