package InterViewPrep;

public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int[] result = Calculate(arr);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    private static int[] Calculate(int[][] arr)
    {
        int[] result = new int[arr.length * arr[0].length];
        int index = 0;

        int r1 = 0, r2 = arr.length-1, c1 = 0, c2 = arr[0].length-1;

        while (r1 <= r2 && c1 <= c2)
        {
            for (int c = c1; c <= c2; c++) {
                result[index++] = arr[r1][c];
            }

            for (int r = r1+1; r <= r2 ; r++) {
                result[index++] = arr[r][c2];
            }

            if (r1 < r2 && c1 < c2)
            {
                for (int c = c2-1; c > c1; c--) {
                    result[index++] = arr[r2][c];
                }

                for (int r = r2; r > r1 ; r--) {
                    result[index++] = arr[r][c1];
                }
            }
            r1++;
            c1++;
            r2--;
            c2--;
        }
        return result;
    }
}
