package InterViewPrep;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class DiagonalTraverse {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        //int[] result = Calculate(arr);
        int[] result = Calculate2(arr);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + ",");
        }
    }

    private static int[] Calculate(int[][] arr)
    {
        HashMap<Integer, LinkedList<Integer>> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {

                int diagonal = i+j;

                if (!map.containsKey(diagonal))
                {
                    map.put(diagonal, new LinkedList<>());
                }
                map.get(diagonal).add(arr[i][j]);
            }
        }

        int index = 0;
        int[] result = new int[arr.length * arr[0].length];
        for (Map.Entry<Integer, LinkedList<Integer>> entry: map.entrySet()) {
            int diagonal = entry.getKey();;
            LinkedList<Integer> list = entry.getValue();

            if (diagonal % 2 == 0)
            {
                while (!list.isEmpty())
                {
                    result[index++] = list.removeLast();
                }
            }
            else
            {
                while (!list.isEmpty())
                {
                    result[index++] = list.removeFirst();
                }
            }
        }

        return result;
    }

    private static int[] Calculate2 (int[][] nums)
    {
        HashMap<Integer, LinkedList<Integer>> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++)
        {
            for (int j = 0; j < nums[0].length; j++)
            {
                int diagonal = i + j;
                if (!map.containsKey(diagonal))
                {
                    map.put(diagonal, new LinkedList<>());
                }
                map.get(diagonal).add(nums[i][j]);
            }
        }

        int index = 0;
        int[] result = new int[nums.length * nums[0].length];

        for(Map.Entry<Integer, LinkedList<Integer>> entry: map.entrySet())
        {
            int diagonal = entry.getKey();
            LinkedList<Integer> list = entry.getValue();

            while(!list.isEmpty())
            {
                result[index++] = list.removeLast();
            }
        }

        return result;
    }
}
