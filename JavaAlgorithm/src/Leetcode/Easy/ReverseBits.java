package Leetcode.Easy;

public class ReverseBits {
    public static void main(String[] args) {
        int result = 0;
        int n = 0000001;
        for (int i = 0; i < 32; i++) {
            result = (result << 1) | ( n & 1);
            n = n >> 1;
        }
        System.out.println(result);
    }
}
