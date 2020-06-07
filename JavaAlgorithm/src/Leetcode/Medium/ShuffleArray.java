package Leetcode.Medium;

import java.util.Random;

public class ShuffleArray {
    static int[] arr;
    static int[] org;
    static Random random;

    public static void main(String[] args) {
        arr = new int[]{1, 2, 3};
        org = arr.clone();
        random = new Random();

        PrintTree(Shuffle());
        System.out.println();
        PrintTree(Reset());
    }

    private static int[] Reset()
    {
        arr = org;
        org = org.clone();
        return arr;
    }

    private static void PrintTree(int[] arr)
    {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
    }

    private static int[] Shuffle()
    {
        for (int i = 0; i < arr.length; i++) {
            Swap(i, nextRand(i, arr.length));
        }
        return arr;
    }

    private static void Swap(int start, int end)
    {
        int temp =arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }

    private static int nextRand(int start, int end)
    {
        return random.nextInt(end - start) + start;
    }

}
