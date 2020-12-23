package Leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class MinimumKnightMoves {

    public static void main(String[] args) {
        minKnightMoves(5,5);
    }

    static class Pair
    {
        int row;
        int col;

        public Pair(int row, int col)
        {
            this.row = row;
            this.col = col;
        }
    }

    public static int minKnightMoves(int x, int y) {
        int[][] neighbours = new int[9][2];
        int[] d = {-1, 1, 2, -2};
        for (int i = 0; i < d.length; i++)
        {
            for (int j= 0; j < d.length; j++)
            {
                if (!(i == 0 && j == 0) &&
                        !(d[i] == d[j]) &&
                        !(Math.abs(d[i]) == Math.abs(d[j])))
                {
                    neighbours[i][0] = d[i];
                    neighbours[i][1] = d[j];
                }

            }

        }



        Set<Pair> visited = new HashSet<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(0, 0));
        visited.add(new Pair(0, 0));

        int result = 0;
        int level = 0;

        while(!queue.isEmpty())
        {
            int size = queue.size();

            for (int i = 0; i < size; i++)
            {
                Pair polled = queue.poll();
                int row = polled.row;
                int col = polled.col;
                if (row == x && col == y) return level;

                for (int[] item : neighbours)
                {
                    int newRow = row + item[0];
                    int newCol = col + item[1];

                    Pair newdir = new Pair(newRow, newCol);
                    if(newRow < 0 || newCol < 0 || newRow >= 300 || newCol >= 300) {
                        continue;
                    }

                    if (!visited.contains(newdir))
                    {
                        visited.add(newdir);
                        queue.add(newdir);
                    }
                }
            }
            level++;
        }
        return 0;
    }
}
