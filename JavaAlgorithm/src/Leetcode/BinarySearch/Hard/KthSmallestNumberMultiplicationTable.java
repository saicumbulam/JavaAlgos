package Leetcode.BinarySearch.Hard;

public class KthSmallestNumberMultiplicationTable {
    public static void main(String[] args) {
        //sample input: int[][] nums = {{1,2,3},{2,4,6},{3,6,9}};
        int m = 3, n = 3, k = 5;
        System.out.println(Calculate(m,n,k));
    }

    private static int Calculate(int m, int n , int k)
    {
        int low = 1;
        int high = m*n;

        while (low < high)
        {
            int mid = low + (high - low)/2;
            if (Enough(mid, m, n) >= k)
            {
                high = mid;
            }
            else
            {
                low = mid+1;
            }
        }

        return low;
    }

    private static int Enough(int mid, int m, int n)
    {
        int count = 0;
        for (int i = 1; i <= m ; i++) {
            count += Math.min(mid/i, n);
        }

        return count;
    }
}
