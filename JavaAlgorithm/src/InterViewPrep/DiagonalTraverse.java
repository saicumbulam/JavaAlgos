package InterViewPrep;

import java.util.*;
import java.util.LinkedList;

public class DiagonalTraverse {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int[] result = Calculate(arr);
        for (int item: result
             ) {
            System.out.println(item);
        }
    }

    private static int[] Calculate(int[][] matrix)
    {
        if(matrix.length == 0) return new int[] {};

        int m = matrix.length;
        int n = matrix[0].length;
        int row = 0;
        int col = 0;

        int[] result = new int[m*n];

        for(int i = 0; i < result.length; i++)
        {
            result[i] = matrix[row][col];

            if((row + col) %2 == 0)
            {
                if (col == n-1)
                {
                    row++;
                }
                else if (row == 0)
                {
                    col++;
                }
                else
                {
                    row--;
                    col++;
                }
            }
            else
            {
                if(row == m-1)
                {
                    col++;
                }
                else if (col == 0)
                {
                    row++;
                }
                else
                {
                    row++;
                    col--;
                }
            }
        }

        return result;
    }
}
