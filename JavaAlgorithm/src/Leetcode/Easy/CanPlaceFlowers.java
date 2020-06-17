package Leetcode.Easy;

public class CanPlaceFlowers {
    public static void main(String[] args) {
        int[] arr = {1,0,0,0,1};
        int n = 1;
        System.out.println(Calculate(arr, n));
    }

    private static boolean Calculate(int[] arr, int n)
    {
        int i = 0, count = 0;
        while (i < arr.length)
        {
            if (arr[i] == 0  && (i == 0 || arr[i-1] == 0) && (i == arr.length-1 || arr[i+1] == 0))
            {
                arr[i] = 1;
                count++;
            }
            i++;
        }

        return count >= n;
    }
}
