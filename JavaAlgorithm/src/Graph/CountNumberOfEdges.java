package Graph;

public class CountNumberOfEdges {
    private static int numEdges(Graph g) {
        int sum = 0;

        for (int i = 0; i < g.vertices; i++) {
            if (g.adjacentList.get(i) != null)
            {
                sum += g.adjacentList.get(i).size();
            }
        }

        return sum/2;
    }

    public static void main(String[] args) {
        Graph g2 = new Graph(7);
        g2.addEdge(1,2);
        g2.addEdge(1,3);
        g2.addEdge(3,4);
        g2.addEdge(3,5);
        g2.addEdge(2,5);
        g2.addEdge(2,4);
        g2.addEdge(4,6);
        g2.addEdge(4,5);
        g2.addEdge(6,5);


        g2.printGraph();
        System.out.println("Number of edges: " + numEdges(g2));
        System.out.println();
    }

}
