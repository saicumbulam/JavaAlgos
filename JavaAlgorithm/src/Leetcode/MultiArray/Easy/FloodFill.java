/*
Done
Given the source location in a matrix,
change all the connecting adjacent cells with the colour from the source cell
* */
package Leetcode.MultiArray.Easy;

public class FloodFill {
    public static void main(String[] args) {
        //int[][] arr = {{1,1,1},{1,1,0},{1,0,1}};
        int[][] arr = {{0,0,0},{0,1,1}};
        //int sr = 1, sc = 1, newColor = 2;
        int sr = 1, sc = 1, newColor = 1;
        Calculate(arr, sr, sc, newColor, arr[sr][sc]);
        
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.println(arr[i][j]);
            }
        }
    }

    private static void Calculate(int[][] image, int sr, int sc,
                           int newColor, int oldColor)
    {
        if (sr < 0 || sr >= image.length || sc < 0
                || sc >= image[0].length || newColor == image[sr][sc]
                || image[sr][sc] != oldColor)
        {
            return;
        }

        image[sr][sc] = newColor;
        Calculate(image, sr+1, sc, newColor, oldColor);
        Calculate(image, sr-1, sc, newColor, oldColor);
        Calculate(image, sr, sc+1, newColor, oldColor);
        Calculate(image, sr, sc-1, newColor, oldColor);
    }
}
