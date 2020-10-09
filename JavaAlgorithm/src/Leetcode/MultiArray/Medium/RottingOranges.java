package Leetcode.MultiArray.Medium;

import javafx.util.Pair;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {
    public static void main(String[] args) {
        int[][] arr = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
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
    public static int Calculate(int[][] grid) {
        Queue<Pair> queue = new LinkedList<>();
        int freshOranges = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) freshOranges++;
                if (grid[i][j] == 2) queue.offer(new Pair(i, j));
            }
        }
        queue.add(new Pair(-1, -1));
        int minutesElapsed = -1;
        int[][] neighbors = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        while (!queue.isEmpty()) {
            Pair polled = queue.poll();
            int row = polled.row;
            int col = polled.col;
            if (row == -1) {
                minutesElapsed++;
                if (!queue.isEmpty()) {
                    queue.add(new Pair(-1, -1));
                }
            } else {
                for (int i = 0; i < neighbors.length; i++) {
                    int neighRow = row + neighbors[i][0];
                    int neighCol = col + neighbors[i][1];

                    if (!(neighRow >=0 && neighRow < grid.length && neighCol >= 0 && neighCol < grid[0].length)) continue;
                    if (grid[neighRow][neighCol] == 1) {
                        grid[neighRow][neighCol] = 2;
                        freshOranges--;
                        queue.add(new Pair(neighRow, neighCol));
                    }
                }
            }
        }
        return freshOranges == 0? minutesElapsed: -1;
    }
}
