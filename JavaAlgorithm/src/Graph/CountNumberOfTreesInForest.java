package Graph;

import java.util.HashSet;

public class CountNumberOfTreesInForest {
    public static void main(String[] args) {
        Graph g = new Graph(5);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(3, 4);

        System.out.println(countTrees(g));
    }

    static HashSet<Integer> visited = new HashSet<>();

    private static int countTrees(Graph g) {
        int res = 0;

        for (int i = 0; i < g.vertices; i++) {
            if (!visited.contains(i))
            {
                dfs(g, i);
                res++;
            }
        }

        return  res;
    }

    private static void dfs(Graph g, int source) {
        visited.add(source);

        for (int item: g.adjacentList.get(source)) {
            if (!visited.contains(item))
            {
                dfs(g, item);
            }
        }
    }


}
