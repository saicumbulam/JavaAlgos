package Leetcode.MultiArray.Medium;

public class RotateImage {
    public static void main(String[] args) {
        int[][] input =  {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };

        for (int i = 0; i < input.length; i++) {
            for (int j = i; j < input[0].length; j++) {
                int temp = input[i][j];
                input[i][j] = input[j][i];
                input[j][i] = temp;
            }
        }

        for (int i = 0; i < input.length; i++) {
            int start = 0, end = input[0].length-1;

            while (start < end)
            {
                int temp = input[i][start];
                input[i][start] = input[i][end];
                input[i][end] = temp;
                start++;
                end--;
            }
        }

        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input.length; j++) {
                System.out.println(input[i][j]);
            }

        }
    }
}
