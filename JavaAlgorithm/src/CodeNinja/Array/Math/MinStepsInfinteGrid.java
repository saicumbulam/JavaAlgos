package CodeNinja.Array.Math;

public class MinStepsInfinteGrid {
    public static void main(String[] args) {
        int[] A = {0,1,1};
        int[] B = {0,1,2};

        int[][] AB = new int[A.length][2];

        for (int i = 0; i < A.length; i++) {
            AB[i][0] = A[i];
            AB[i][1] = B[i];
        }

        System.out.println(Calc(AB));
    }

    private static int Calc(int[][] arr)
    {
        int sum = 0;

        for (int i = 1; i < arr.length; i++) {
            sum += distance(arr[i], arr[i-1]);
        }

        return sum;
    }

    private static int distance(int[] point1, int[] point2)
    {
        int xmax = Math.abs(point1[0] - point2[0]);
        int ymax = Math.abs(point1[1] - point2[1]);
        return Math.max(xmax, ymax);
    }
}
