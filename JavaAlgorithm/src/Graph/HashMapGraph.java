package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HashMapGraph {
    int vertices;
    HashMap<Integer, List<Integer>> adjacentList;

    public HashMapGraph(int vertices) {
        this.vertices = vertices;
        adjacentList = new HashMap<>();

        for (int i = 0; i < vertices; i++) {
            adjacentList.put(i, new ArrayList<>());
        }
    }
}
