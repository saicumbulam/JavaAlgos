package Leetcode.BitWise.Easy.Often;

public class SingleNumber {
    public static void main(String[] args) {
        int[] arr = new int[] { 2,2,1};
        System.out.println(calculate(arr));
    }

    public static int calculate(int[] arr)
    {
        int num = 0;
        for (int i = 0; i < arr.length; i++)
        {
            num ^= arr[i];
        }

        return num;
    }
}
