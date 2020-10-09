package InterViewPrep;

import java.util.*;

public class AccountsMerge {

    public static void main(String[] args) {
        List<List<String>> list = new ArrayList<>();
        list.add(Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com"));
        list.add(Arrays.asList("John", "johnnybravo@mail.com"));
        list.add(Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com"));
        list.add(Arrays.asList("Mary", "mary@mail.com"));

        System.out.println(Calculate(list));
    }

    private static List<List<String>> Calculate (List<List<String>> accounts)
    {
        List<List<String>> results = new ArrayList<>();
        HashMap<String, Account> map = new HashMap<>();

        for(List<String> emails : accounts) {
            String name = emails.get(0);
            String key = emails.get(1);

            /* add the email as key into the map */
            if( ! map.containsKey(key)) {
                Account account = new Account(name);
                map.put(key, account);
            }

            /* build adjacency list */
            for(int i = 2; i < emails.size(); i++) {
                String email = emails.get(i);
                map.get(key).emails.add(email);

                /* create a back edge to the key email */
                if( ! map.containsKey(email)) {
                    /* this email will also point to the same account name */
                    map.put(email, new Account(name));
                }

                map.get(email).emails.add(key);
            }
        }

        Set<String> visited = new HashSet<>();
        for(String email : map.keySet()) {

            if( ! visited.contains(email)) {
                List<String> list = new ArrayList<>();
                list.add(map.get(email).name);

                dfs(map, visited, list, email);

                /* sort the list */
                Collections.sort(list);
                results.add(list);
            }
        }

        return results;
    }


    private static void dfs(HashMap<String, Account> map,
                     Set<String> visited, List<String> list, String email)
    {
        list.add(email);
        visited.add(email);

        for (String neighbour: map.get(email).emails)
        {
            if(!visited.contains(neighbour))
            {
                dfs(map, visited, list, neighbour);
            }
        }
    }

    static class Account {
        String name;
        List<String> emails;

        Account(String name) {
            this.name = name;
            this.emails = new ArrayList<>();
        }
    }
}
