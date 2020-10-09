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
        List<List<Integer>> input = new ArrayList<>();
        input.add(Arrays.asList(1,2,3));
        input.add(Arrays.asList(4,5,6));
        input.add(Arrays.asList(7,8,9));

        System.out.println(Calculate(input));
    }

    private static List<Integer> Calculate(List<List<Integer>> array)
    {
        int m = array.size()-1;
        int n = array.get(0).size()-1;

        int row = 0;
        int col = 0;
        boolean goingDown = true;
        List<Integer> result = new ArrayList<>();

        while(!(row < 0 || row > m || col < 0 || col > n ))
        {
            result.add(array.get(row).get(col));

            if(goingDown)
            {
                if (row == m || col == 0)
                {
                    goingDown = false;

                    if(row == m)
                    {
                        col++;
                    }
                    else
                    {
                        row++;
                    }
                }
                else
                {
                    row++;
                    col--;
                }
            }
            else
            {
                if(row == 0 || col == n)
                {
                    goingDown = true;

                    if(col == n)
                    {
                        row++;
                    }
                    else
                    {
                        col++;
                    }
                }
                else
                {
                    row--;
                    col++;
                }
            }
        }

        return result;
    }
}
