package Algorithms.Array;

import java.util.Arrays;

public class CheckPermutation2Str {
    public static void main(String[] args) {
        char str1[] = ("geeksforgeeks").toCharArray();
        char str2[] = ("forgeeksgeeks").toCharArray();
        if (arePermutation(str1,str2)) {
            System.out.println("Both strings are permuation");
        } else {
            System.out.println("Both strings are not permuation");
        }
    }

    private static boolean arePermutation(char[] str1, char[] str2) {
        if (str1.length != str2.length) {
            return false;
        }

        int length = 256;

        int[] count1 = new int[length];
        Arrays.fill(count1,0);
        int[] count2 = new int[length];
        Arrays.fill(count2,0);

        for (int i = 0; i < str1.length; i++) {
            count1[str1[i]]++;
            count2[str2[i]]++;
        }

        for (int i = 0; i < length; i++) {
            if (count1[i] != count2[i]) {
                return false;
            }
        }
        return true;
    }
}
