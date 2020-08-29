package InterViewPrep;

public class MinimumDominoRotated {
    public static void main(String[] args) {
        int[] A = {2,1,2,4,2,2};
        int[] B = {5,2,6,2,3,2};
        System.out.println(minDominoRotations(A, B));
    }

    private static int minDominoRotations(int[] A, int[] B) {
        int result = Check(A[0], A, B);
        if (result == -1)
        {
            result = Check(B[0], A, B);
        }

        return result;
    }

    private static int Check(int item, int[] A, int[] B)
    {
        int countA = 0, countB = 0;
        for(int i = 1; i < A.length; i++)
        {
            if (A[i] != item && B[i] != item)
            {
                return -1;
            }

            if (A[i] != item)
            {
                countA++;
            }

            if (B[i] != item)
            {
                countB++;
            }
        }

        return Math.min(countA, countB);
    }
}
