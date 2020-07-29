package Leetcode.String.Easy.Easy;

import java.util.*;

class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;

    public Employee(int id, int importance, List<Integer> subordinates) {
        this.id = id;
        this.importance = importance;
        this.subordinates = subordinates;
    }
};

public class EmployeeImportance {
    public static void main(String[] args) {
        List<Employee> newList = new ArrayList<>();
        newList.add(new Employee(1, 5, Arrays.asList(2,3)));
        newList.add(new Employee(2, 3, new ArrayList<>()));
        newList.add(new Employee(3, 3, new ArrayList<>()));
        System.out.println(getImportance(newList, 1));
    }

    public static int getImportance(List<Employee> employees, int id) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        set.add(id);

        for (int i = 0; i < employees.size(); i++)
        {
            int parent = employees.get(i).id;
            List<Integer> childrens =  employees.get(i).subordinates;
            graph.put(parent, childrens);
        }


        set.add(id);

        for (int item: graph.get(id))
        {
            set.add(item);
        }

        for (Map.Entry<Integer, List<Integer>> entry: graph.entrySet())
        {
            if (set.contains(entry.getKey()) && entry.getKey() != id)
            {
                for (int item: entry.getValue())
                {
                    set.add(item);
                }
            }
        }

        int sum = 0;

        for (int i = 0; i < employees.size(); i++)
        {
            if (set.contains(employees.get(i).id))
            {
                sum += employees.get(i).importance;
            }
        }

        return sum;
    }
}
