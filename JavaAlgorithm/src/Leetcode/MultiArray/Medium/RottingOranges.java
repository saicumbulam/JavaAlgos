package Leetcode.MultiArray.Medium;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {
    private static int[][] neigh = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    private static int count = 0;
    public static void main(String[] args) {
        int[][] arr = {{2,1,1},{1,1,0},{0,1,1}};
        //int[][] arr = {{1,1,2,0,2,0}};
        //int[][] arr = {{2, 1, 1}, {0, 1, 1}, {1, 0, 1}};
        //int[][] arr = {{1,2,1,1,2,1,1}};
        //int[][] arr = {{1,2}};
        System.out.println(Calculate(arr));
    }

    static class Pair
    {
        int row;
        int col;

        public Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    
    private static int Calculate(int[][] grid) {
        int freshOranges = 0;
        Queue<Pair> queue  = new LinkedList<>();

        for (int i = 0; i < grid.length ; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 2)
                {
                    queue.add(new Pair(i, j));
                }
                if(grid[i][j] == 1)
                {
                    freshOranges++;
                }
            }
        }

        queue.add(new Pair(-1, -1));

        int timer = -1;

        while (!queue.isEmpty())
        {
            Pair polled = queue.poll();
            int row = polled.row;
            int col = polled.col;;

            if(row == -1)
            {
                timer++;

                if(!queue.isEmpty())
                {
                    queue.add(new Pair(-1, -1));
                }
            }
            else
            {
                for (int[] d: neigh)
                {
                    int neighRow = row + d[0];
                    int neighCol = col + d[1];

                    if(neighCol >= 0 && neighCol < grid[0].length
                    && neighRow >= 0 && neighRow < grid.length)
                    {
                        if(grid[neighRow][neighCol] == 1)
                        {
                            grid[neighRow][neighCol] = 2;
                        }
                        queue.add(new Pair(neighRow, neighCol));
                    }
                }
            }
        }

        return freshOranges == 0 ? timer : -1;
    }


}
