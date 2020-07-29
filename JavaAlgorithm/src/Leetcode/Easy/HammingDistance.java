package Leetcode.String.Easy.Easy;

public class HammingDistance {
    public static void main(String[] args) {
        int x = 1, y = 4;

        int xor = x ^ y;
        int distance = 0;

        while (xor != 0)
        {
            xor = xor & (xor-1);
            distance++;
        }

        System.out.println(distance);
    }
}
