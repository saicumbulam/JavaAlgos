package Graph;

public class CountAllPossiblePathsBetweenTwoVertices {
    public static void main(String[] args) {
        Graph g = new Graph(5);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(0, 3);
        g.addEdge(1, 3);
        g.addEdge(2, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 4);

        int s = 0, d = 3;
        System.out.println(countPaths(g,s, d));
    }

    static int count = 0;
    private static int countPaths(Graph g, int source, int destination) {
        dfs(g, source, destination);
        return count;
    }

    private static void dfs(Graph g, int source, int destination) {
        if (source == destination)
        {
            count++;
            return;
        }

        for (int item: g.adjacentList.get(source)) {
            dfs(g, item, destination);
        }
    }


}
