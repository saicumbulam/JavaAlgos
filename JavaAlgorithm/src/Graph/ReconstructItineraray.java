package Graph;

import java.util.*;

public class ReconstructItineraray {
    static HashMap<String, PriorityQueue<String>> flights;
    static List<String> path;

    public static void main(String[] args) {
        List<List<String>> paths = new ArrayList<>();
        paths.add(Arrays.asList("JFK","SFO"));
        paths.add(Arrays.asList("JFK","ATL"));
        paths.add(Arrays.asList("SFO","ATL"));
        paths.add(Arrays.asList("ATL","JFK"));
        paths.add(Arrays.asList("ATL","SFO"));
        System.out.println(findItinerary(paths));
    }

    public static List<String> findItinerary(List<List<String>> tickets) {
        flights = new HashMap<>();
        path = new ArrayList<>();

        for (List<String> ticket : tickets) {
            flights.putIfAbsent(ticket.get(0), new PriorityQueue<>());
            flights.get(ticket.get(0)).add(ticket.get(1));
        }

        Stack<String> stack = new Stack<>();
        stack.add("JFK");
        path.add("JFK");

        while(!stack.isEmpty())
        {
            String polled = stack.pop();
            PriorityQueue<String> arrivals = flights.get(polled);

            while (arrivals != null && !arrivals.isEmpty())
            {
                String departure = arrivals.poll();
                path.add(departure);
                stack.add(departure);
            }
        }
        return path;
    }
}
