package Leetcode.String.Easy.Easy;

public class ShortestWordDistance {
    public static void main(String[] args) {
        String[] strs = {"practice", "makes", "perfect", "coding", "makes"};
        String word1 = "coding", word2 = "practice";
        System.out.println(Calculate(strs, word1, word2));
    }

    private static int Calculate(String[] strs, String word1, String word2)
    {
        int i1 = -1, i2 = -1;
        int minDistance = Integer.MAX_VALUE;
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].equals(word1))
            {
                i1 = i;
            }
            else if (strs[i].equals(word2))
            {
                i2 = i;
            }

            if (i1 != -1 && i2 != -1)
            {
                minDistance = Math.min(minDistance, Math.abs(i1 - i2));
            }

        }

        return minDistance;
    }
}
