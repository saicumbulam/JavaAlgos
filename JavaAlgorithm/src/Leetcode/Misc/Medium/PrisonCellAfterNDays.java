package Leetcode.Misc.Medium;

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
        n = (n - 1) % 14 + 1;  // for optimization since pattern repeated every 14 days.
        for(int i = 0; i < n; i++)
            cells = nextDayState(cells);
        return cells;
    }

    private static int[] nextDayState(int[] cells) {
        int[] next = new int[cells.length];
        for(int i = 1; i < cells.length - 1; i++)
            next[i] = cells[i - 1] == cells[i + 1] ? 1 : 0;
        return next;
    }
}
