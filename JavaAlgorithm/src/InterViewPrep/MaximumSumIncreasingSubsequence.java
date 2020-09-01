package InterViewPrep;

public class MaximumSumIncreasingSubsequence {
    public static void main(String[] args) {
        int[] arr = {4,1,2,6,10,1,12};
        System.out.println(Calculate(arr, -1, 0, 0));
    }

    private static int Calculate(int[] arr, int prevIndex, int curIndex, int count)
    {
        if (curIndex == arr.length)
        {
            return count;
        }

        int c1 = count;
        if (prevIndex == -1 || arr[curIndex] > arr[prevIndex])
        {
            c1 = Calculate(arr, curIndex, curIndex+1, count+arr[curIndex]);
        }

        int c2 = Calculate(arr, prevIndex, curIndex+1, count);

        return Math.max(c1, c2);
    }
}
