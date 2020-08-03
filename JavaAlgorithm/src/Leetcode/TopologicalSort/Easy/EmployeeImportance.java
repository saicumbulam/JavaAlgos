package Leetcode.TopologicalSort.Easy;

import java.util.*;


public class EmployeeImportance {
    static class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;

        public Employee(int id, int importance, List<Integer> subordinates) {
            this.id = id;
            this.importance = importance;
            this.subordinates = subordinates;
        }
    };

    public static void main(String[] args) {
        List<Employee> newList = new ArrayList<>();
        newList.add(new Employee(1, 5, Arrays.asList(2,3)));
        newList.add(new Employee(2, 3, new ArrayList<>()));
        newList.add(new Employee(3, 3, new ArrayList<>()));
        System.out.println(getImportance(newList, 1));
    }

    public static int getImportance(List<Employee> employees, int id) {
        int sum = 0;
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        HashMap<Integer, Employee> dict = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        set.add(id);

        for (int i = 0; i < employees.size(); i++)
        {
            int parent = employees.get(i).id;
            List<Integer> childrens =  employees.get(i).subordinates;
            graph.put(parent, childrens);
            dict.put(parent, employees.get(i));
        }

        Queue<Integer> source = new LinkedList<>();
        source.add(id);

        while (!source.isEmpty())
        {
            int polled = source.poll();
            List<Integer> children = graph.get(polled);
            sum += dict.get(polled).importance;

            for (int child: children
                 ) {
                source.offer(child);
            }
        }

        return sum;
    }
}
