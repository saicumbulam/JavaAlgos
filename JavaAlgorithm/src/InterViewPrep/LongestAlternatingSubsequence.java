package InterViewPrep;

public class LongestAlternatingSubsequence {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        System.out.println(Math.max(Calculate(arr, -1, 0, true),
                Calculate(arr, -1, 0, false)));
    }

    private static int Calculate(int[] arr, int prev, int curr, boolean asc)
    {
        if (curr == arr.length)
        {
            return 0;
        }

        int c1 = 0;
        if (asc)
        {
            if (prev == -1 || arr[prev] < arr[curr])
            {
                c1 = 1 + Calculate(arr, curr, curr + 1, !asc);
            }
        }
        else
        {
            if (prev == -1 || arr[prev] > arr[curr])
            {
                c1 = 1 + Calculate(arr, curr, curr + 1, !asc);
            }
        }

        int c2 = Calculate(arr, prev, curr + 1, asc);

        return Math.max(c1, c2);
    }
}
