package InterViewPrep;

public class MaximumSwap {
    public static void main(String[] args) {
        System.out.println(Calculate(2736));
    }

    public static int Calculate(int num) {
        char[] A = Integer.toString(num).toCharArray();
        int[] last = new int[10];

        for (int i = 0; i < A.length; i++) {
            System.out.println(A[i] - '0');
            last[A[i] - '0'] = i;
        }

        for (int i = 0; i < A.length; i++) {
            for (int d = 9; d > A[i] - '0'; d--) {
                if (last[d] > i) {
                    char tmp = A[i];
                    A[i] = A[last[d]];
                    A[last[d]] = tmp;
                    return Integer.valueOf(new String(A));
                }
            }
        }
        return num;
    }
}
