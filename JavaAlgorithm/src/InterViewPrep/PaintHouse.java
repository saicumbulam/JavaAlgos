package InterViewPrep;

public class PaintHouse {
    public static void main(String[] args) {
        int[][] arr = {{17,2,17},{16,16,5},{14,3,19}};
        System.out.println(Calculate(arr));
    }

    private static int Calculate(int[][] arr)
    {
        if (arr.length == 0)
        {
            return 0;
        }

        return Math.min(Paint(arr, 0, 0), Math.min(Paint(arr, 0, 1)
        , Paint(arr, 0, 2)));
    }

    private static int Paint(int[][] arr, int r, int c)
    {
        int totalCost = arr[r][c];

        if (r != arr.length-1)
        {
            if (c == 0)
            {
                totalCost += Math.min(Paint(arr, r+1, 1), Paint(arr, r+1, 2));
            }
            else if (c == 1)
            {
                totalCost += Math.min(Paint(arr, r+1, 0), Paint(arr, r+1, 2));
            }
            else
            {
                totalCost += Math.min(Paint(arr, r+1, 0), Paint(arr, r+1, 1));
            }
        }
        return totalCost;

    }
}
