package InterViewPrep;

import java.util.Arrays;
import java.util.Comparator;

public class QueueReconstructionByHeight {
    public static void main(String[] args) {
        int[][] arr = {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
        Calculate(arr);

        for (int[] item: arr
             ) {
            System.out.println(item[0] + ", " + item[1]);
        }
    }

    private static void Calculate(int[][] arr)
    {

        Arrays.sort(arr, new Com());
    }

    static class Com implements Comparator<int[]>
    {
        @Override
        public int compare(int[] o1, int[] o2) {
            return o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0];
        }
    }
}
