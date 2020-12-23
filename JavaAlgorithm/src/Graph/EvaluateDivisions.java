package Graph;

import java.util.*;

public class EvaluateDivisions {
    public static void main(String[] args) {
        List<List<String>> equations = new ArrayList<>();
        equations.add(Arrays.asList("a", "b"));
        equations.add(Arrays.asList("b", "c"));

        double[] arr = new double[]{2.0, 3.0};

        List<List<String>> queries = new ArrayList<>();
        queries.add(Arrays.asList("a", "c"));
        queries.add(Arrays.asList("b", "a"));
        queries.add(Arrays.asList("a", "e"));
        queries.add(Arrays.asList("a", "a"));
        queries.add(Arrays.asList("x", "x"));

        double[] result = calcEquation(equations, arr, queries);
        for (double item: result
             ) {
            System.out.println(item);
        }
    }

    static class dest
    {
         String vertex;
         double distance;

        public dest(String vertex, double destination)
        {
            this.vertex = vertex;
            this.distance = destination;
        }
    }
    public static double[] calcEquation(List<List<String>> equations,
                                 double[] values,
                                 List<List<String>> queries)
    {
        HashMap<String, dest> map = new HashMap<>();

        for (int i = 0; i < equations.size(); i++) {
            double value = values[i];
            List<String> item = equations.get(i);
            map.put(item.get(0), new dest(item.get(1), value));
            map.put(item.get(1), new dest(item.get(0), 1/value));
        }

        double[] queriesValues = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            queriesValues[i] = dfs(map, queries.get(i).get(0),
                                    queries.get(i).get(1));
        }

        return queriesValues;
    }


    private static double dfs(HashMap<String, dest> map, String source, String destination)
    {
        if (!map.containsKey(source) || !map.containsKey(destination))
        {
            return -1;
        }
        if (source.equals(destination)) return 1;

        Queue<String> queue = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        queue.add(source);
        visited.add(source);
        double sum = 1;

        while (!queue.isEmpty())
        {
            String polled = queue.poll();
            if(polled.equals(destination))
            {
                break;
            }
            if(map.containsKey(polled) && !visited.contains(map.get(polled).vertex))
            {
                sum *= map.get(polled).distance;
                queue.add(map.get(polled).vertex);
                visited.add(map.get(polled).vertex);
            }
        }
        return sum;
    }
}
