package Leetcode.Array.Easy;

public class RunningSum {
    public static void main(String[] args) {
        //int[] arr = {1,2,3,4};
        int[] arr = {3,1,2,10,1};
        int[] result = Calculate(arr);
        for (int item: result
             ) {
            System.out.println(item);
        }
    }

    private static int[] Calculate(int[] arr)
    {
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            count += arr[i];
            arr[i] = count;
        }
        return arr;
    }
}
