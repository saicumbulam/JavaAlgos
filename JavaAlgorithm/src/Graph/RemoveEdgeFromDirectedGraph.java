package Graph;

public class RemoveEdgeFromDirectedGraph {
    public static void main(String[] args) {
        Graph g=new Graph(5);
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(1,3);
        g.addEdge(3,4);
        g.addEdge(1,4);

        System.out.println("Before:");
        g.printGraph();

        removeEdge(g, 1, 3);
        System.out.println("After:");
        g.printGraph();
    }

    private static void removeEdge(Graph g, int source, int destination) {
        g.adjacentList.get(source).removeIf(e -> e == destination);
    }
}
