package Leetcode.Array.Alter;

public class SecondMaximum {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        System.out.println(Calculate(arr));
    }

    private static int Calculate(int[] arr)
    {
        int maximum = Integer.MIN_VALUE;
        int second_maximum = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (maximum < arr[i])
            {
                maximum = arr[i];
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (second_maximum < arr[i] && arr[i] != maximum)
            {
                second_maximum = arr[i];
            }
        }


        return second_maximum;
    }
}
