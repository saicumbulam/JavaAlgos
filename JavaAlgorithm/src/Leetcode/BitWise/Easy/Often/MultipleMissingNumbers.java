package Leetcode.BitWise.Easy.Often;

import java.util.ArrayList;
import java.util.List;

public class MultipleMissingNumbers {
    public static void main(String[] args) {
        int[] arr = {4,3,2,7,8,3,2,1};
        System.out.println(Calculate(arr));
    }

    private static List<Integer> Calculate(int[] arr)
    {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            int j = Math.abs(arr[i])-1;
            if(arr[j] > 0) arr[j] *= -1;
        }

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > 0) list.add(i+1);
        }

        return list;
    }
}
