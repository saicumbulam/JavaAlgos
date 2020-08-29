package InterViewPrep;

import java.util.ArrayList;
import java.util.List;

public class LargestDivisibleSubset {
    public static void main(String[] args) {
        int[] arr = {1, 16, 7, 8, 4};
        //int[] arr = {2, 4, 3, 8};
        System.out.println(Calculate(arr, 0, -1,new ArrayList<>()));
    }

    private static List<Integer> Calculate(int[] arr, int curIdx, int prevIdx, List<Integer> curr)
    {
        if (curIdx >= arr.length)
        {
            return curr;
        }

        List<Integer> c1 = new ArrayList<>(curr);
        if (prevIdx == -1 || arr[curIdx] % arr[prevIdx] == 0 || arr[prevIdx] % arr[curIdx] == 0)
        {
            c1.add(arr[curIdx]);
            c1 = Calculate(arr, curIdx+1, curIdx, c1);
        }

        List<Integer> c2 = Calculate(arr, curIdx+1, prevIdx, curr);

        if (c1.size() > c2.size())
        {
            return c1;
        }
        return c2;
    }
}
