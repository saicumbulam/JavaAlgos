package Leetcode.Array.Easy;

import java.util.Arrays;
import java.util.List;

public class ValidSubsequence {
    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1,2,3,4);
        List<Integer> list2 = Arrays.asList(2,4);
        System.out.println(isValidSubsequence(list1, list2));
    }

    public static boolean isValidSubsequence(List<Integer> array,
                                             List<Integer> sequence) {
        int arrayIdx = 0, seqIdx = 0;

        while (arrayIdx < array.size() && seqIdx < sequence.size())
        {
            if (array.get(arrayIdx).equals(sequence.get(seqIdx)))
            {
                seqIdx++;
            }
            arrayIdx++;
        }

        return seqIdx == sequence.size();
    }

}
