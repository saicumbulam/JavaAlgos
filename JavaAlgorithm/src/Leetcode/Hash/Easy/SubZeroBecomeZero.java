package Leetcode.Hash.Easy;

import java.util.HashMap;

public class SubZeroBecomeZero {
    public static void main(String[] args) {
        int[] arr = {6,4,-7,3,12,9};
        System.out.println(Calculate(arr));
    }

    private static boolean Calculate(int[] arr)
    {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (sum == 0 || map.get(sum) != null || arr[i] == 0)
            {
                return true;
            }
            map.put(sum, i);
        }
        return false;
    }
}
