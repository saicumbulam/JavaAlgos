package Leetcode.Medium;

import java.util.HashMap;

public class FourSum2 {
    public static void main(String[] args) {
        int[] A = {1, 2};
        int[] B = {-2,-1};
        int[] C = {-1, 2};
        int[] D = {0, 2};

        int count = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                int sum = A[i] + B[j];
                hashMap.put(sum, hashMap.getOrDefault(sum, 0) + 1);
            }
        }


        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                int sum = -(C[i] + D[j]);
                if (hashMap.containsKey(sum))
                {
                    count += hashMap.get(sum);
                }
            }
        }
        System.out.println(count);
    }
}
