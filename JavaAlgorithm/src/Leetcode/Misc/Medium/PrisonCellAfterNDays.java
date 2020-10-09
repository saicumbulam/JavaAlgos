package Leetcode.Misc.Medium;

import java.util.Arrays;
import java.util.HashSet;

public class PrisonCellAfterNDays {
    public static void main(String[] args) {
        int[] cells = {0,1,0,1,1,0,0,1};
        int N = 17;
        int[] result = Calculate(cells, N);
        for (int item: result
             ) {
            System.out.println(item);
        }
    }

    private static int[] Calculate(int[] cells, int n)
    {
        HashSet<String> set = new HashSet<>();
        int iteration = 0;
        boolean isCycle = false;
        int i = 0;
        while ( i < n)
        {
            int[] nextState = findNextState(cells);
            String key = Arrays.toString(nextState);
            if (set.contains(key))
            {
                isCycle = true;
                break;
            }
            else
            {
                set.add(key);
                iteration++;
                i++;
            }
            cells = nextState;
        }

        int j = 0;
        if (isCycle)
        {
            n %= iteration;
            while (j < n)
            {
                cells = findNextState(cells);
                j++;
            }
        }

        return cells;
    }

    private static int[] findNextState(int[] cells)
    {
        int[] next = new int[cells.length];
        for (int i = 1; i < cells.length-1; i++) {
            next[i] = cells[i-1] == cells[i+1] ? 1 : 0;
        }
        return next;
    }
}
