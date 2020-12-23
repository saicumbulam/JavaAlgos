package InterViewPrep;

public class BinarySubarraysWithSum {
    public static void main(String[] args) {
        numSubarraysWithSum(new int[]{1,0,1,0,1}, 2);
    }


    public static int numSubarraysWithSum(int[] A, int S) {
        int total = atMost(A, S);
        int total_1 = atMost(A, S-1);

        return total - total_1;
    }

    public static int atMost(int[] A, int S) {
        if (S < 0) return 0;
        int res = 0, i = 0, n = A.length;
        for (int j = 0; j < n; j++) {
            S -= A[j];
            while (S < 0)
                S += A[i++];
            res += j - i + 1;
        }
        return res;
    }
}
