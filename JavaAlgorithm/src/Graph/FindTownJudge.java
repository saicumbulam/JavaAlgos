package Graph;

import java.util.*;

public class FindTownJudge {
    public static void main(String[] args) {
        int N = 3;
        int[][] trust = {{1,3}, {2,3}};
        System.out.println(Find(N, trust));
    }

    private static int Find(int n, int[][] trust) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            map.put(i, new ArrayList<>());
        }

        for (int i = 0; i < trust.length; i++) {
            map.get(trust[i][0]).add(trust[i][1]);
        }

        int vertex = 0;
        for(Map.Entry<Integer,List<Integer>> entry: map.entrySet())
        {
            if(entry.getValue().size() == 0)
            {
                vertex =  entry.getKey();
                break;
            }
        }

        for(Map.Entry<Integer,List<Integer>> entry: map.entrySet())
        {
            if(entry.getKey() != vertex && !entry.getValue().contains(vertex))
            {
                return -1;
            }
        }

        return vertex;
    }


}
