package Leetcode.Array.Alter;

public class MoveZeroes {
    public static void main(String[] args) {
        int[] arr = new int[]{0,1,0,3,12};

        int zeroes = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0)
            {
                arr[zeroes++] = arr[i];
            }
        }

        while (zeroes < arr.length)
        {
            arr[zeroes++] = 0;
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        };
    }
}
