package Leetcode.BitWise.Easy.Often;

public class MissingNumber {
    public static void main(String[] args) {
        int[] arr = new int[] {3,0,1};
        int n = arr.length;
        int num = 0;

        for (int i = 0; i <= n ; i++) {
            num ^= i;
        }

        for (int i = 0; i < arr.length; i++) {
            num ^= arr[i];
        }

        System.out.println("Missing number: " + num);;
    }
}
