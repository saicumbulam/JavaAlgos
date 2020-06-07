package Leetcode.Easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class IntersectionOfTwoArrays {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,2,1};
        int[] nums2 = new int[]{2,2};
        int[] result = Calculate(nums1, nums2);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    public static int[] Calculate(int[] nums1, int[] nums2)
    {
        List<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < nums1.length; i++) {
            hashMap.put(nums1[i], hashMap.getOrDefault(nums1[i], 0) + 1);
        }

        for (int i = 0; i < nums2.length; i++) {
            if (hashMap.containsKey(nums2[i]))
            {
                list.add(nums2[i]);
                if (hashMap.get(nums2[i]) == 0)
                {
                    hashMap.remove(nums2[i]);
                }
            }
        }

        // efficient method to return a integer. time saver
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
