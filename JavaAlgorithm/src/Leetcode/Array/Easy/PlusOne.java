package Leetcode.String.Easy.Easy;

public class PlusOne {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3};
        int[] temp = Calculate(arr);
        for (int i = 0; i < temp.length; i++) {
            System.out.println(temp[i]);
        }
    }

    private static int[] Calculate(int[] arr) {
        for (int i = arr.length-1; i >= 0 ; i--) {
            if(arr[i] == 9)
            {
                arr[i] = 0;
            }
            else
            {
                arr[i] += 1;
                return arr;
            }
        }

        int[] temp = new int[arr.length+1];
        temp[0] = 1;

        return temp;
    }
}
