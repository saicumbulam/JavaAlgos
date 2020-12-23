package Graph;

public class TransposeGraph {
    public static void main(String[] args) {
        Graph g = new Graph(5);

        g.addEdge(0, 1);
        g.addEdge(0, 4);
        g.addEdge(0, 3);
        g.addEdge(2, 0);
        g.addEdge(3, 2);
        g.addEdge(4, 1);
        g.addEdge(4, 3);
        g.printGraph();

        System.out.println("After graph");
        Graph t = getTranspose(g);
        t.printGraph();
    }

    private static Graph getTranspose(Graph g) {
        Graph t = new Graph(g.vertices);

        for(int i = 0; i < g.vertices; i++)
        {
            for (int j: g.adjacentList.get(i)) {
                t.addEdge(j, i);
            }
        }
        return t;
    }
}
