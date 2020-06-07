package Leetcode.Easy;

import java.util.HashMap;

public class MajorityElement {
    public static void main(String[] args) {
        int[] arr = new int[]{3,2,3};
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            hashMap.put(arr[i], hashMap.getOrDefault(arr[i], 0) + 1);
        }

        for (int i = 0; i < arr.length; i++) {
            if (hashMap.get(arr[i]) > arr.length/2)
            {
                System.out.println("Element is: " + arr[i]);
                break;
            }
        }
    }
}
