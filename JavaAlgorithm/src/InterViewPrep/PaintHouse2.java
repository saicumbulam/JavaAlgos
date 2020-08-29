package InterViewPrep;

public class PaintHouse2 {
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

        int minimum = Integer.MAX_VALUE;

        for (int i = 0; i < arr[0].length; i++) {
            minimum = Math.min(minimum, Paint(arr, 0, i));
        }
        return minimum;
    }

    private static int Paint(int[][] arr, int r, int c)
    {
        int totalCost = arr[r][c];

        int minRemainingCost = Integer.MAX_VALUE;
        if (r != arr.length-1)
        {
            for (int i = 0; i < arr[0].length; i++) {
                if (i == c)
                {
                    continue;
                }
                int curRemainingCost = Paint(arr, r+1, i);
                minRemainingCost = Math.min(minRemainingCost, curRemainingCost);
            }
            totalCost += minRemainingCost;
        }
        return totalCost;

    }
}
