package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AllPathsFromSourceToTarget {
    public static void main(String[] args) {
        //int[][] arr = {{1,2},{3},{3},{}};
        int[][] arr = {{4,3,1},{3,2,4},{3},{4},{}};
        Find(arr);
    }

    static List<List<Integer>> result = new ArrayList<>();

    private static void Find(int[][] arr)
    {
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            map.put(i, new ArrayList<>());
        }

        for (int i = 0; i < arr.length; i++) {
            for (int item: arr[i]) {
                map.get(i).add(item);
            }
        }

        List<Integer> curr = new ArrayList<>();
        curr.add(0);
        dfs(map,0, arr.length-1, curr);
        System.out.println(result);
    }

    private static void dfs(HashMap<Integer, List<Integer>> map,
                            int source, int destination,
                            List<Integer> curr)
    {
        if(source == destination)
        {
            result.add(new ArrayList<>(curr));
            return;
        }

        for (int item : map.get(source)) {
            curr.add(item);
            dfs(map, item, destination, curr);
            curr.remove(curr.size()-1);
        }
    }
}
