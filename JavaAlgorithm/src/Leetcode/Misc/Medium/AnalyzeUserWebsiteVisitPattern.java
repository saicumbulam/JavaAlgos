/*
Risky
* */
package Leetcode.Misc.Medium;

import java.util.*;

public class AnalyzeUserWebsiteVisitPattern {
    public static void main(String[] args) {
        String[] username = {"joe","joe","joe","james","james","james","james","mary","mary","mary"};
        int[] timestamp = {1,2,3,4,5,6,7,8,9,10};
        String[] website = {"home","about","career","home","cart","maps","home","home","about","career"};
        System.out.println(Calculate(username, timestamp, website));
    }

    private static List<String> Calculate(String[] username, int[] timestamp, String[] website) {
        HashMap<String, User> map = new HashMap<>();
        for (int i = 0; i < username.length; i++) {
            if(map.containsKey(username[i]))
            {
               map.get(username[i]).addWebsite(website[i]);
            }
            else
            {
                map.put(username[i],new User(username[i], timestamp[i], website[i]));
            }
        }

        for (Map.Entry<String, User> entry: map.entrySet()
             ) {
            entry.getValue().GetStrings();
        }

        HashMap<String, Integer> freq = new HashMap<>();
        for (Map.Entry<String, User> entry: map.entrySet()
        ) {
            for (String item: entry.getValue().all
                 ) {
                freq.put(item, freq.getOrDefault(item, 0)+1);
            }
        }
        int maxItem = 0;
        String maxEntry = "";

        for (Map.Entry<String, Integer> entry: freq.entrySet()
             ) {
            if (entry.getValue() > maxItem)
            {
                maxItem = entry.getValue();
                maxEntry = entry.getKey();
            }
        }
        return Arrays.asList(maxEntry.split(","));

    }

    static class User
    {
        String userName;
        int timestamp;
        List<String> website = new ArrayList<>();
        List<String> all = new ArrayList<>();

        public User(String userName, int timestamp, String website) {
            this.userName = userName;
            this.timestamp = timestamp;
            this.website.add(website);
        }

        public void addWebsite(String str)
        {
            this.website.add(str);
        }

        private void GetStrings()
        {
            List<String> result = new ArrayList<>();

            if(this.website.size() > 3)
            {
                List<List<String>> perms = permCalc(this.website);
                for (List<String> item: perms
                     ) {
                    int count = 0;
                    StringJoiner str = new StringJoiner(",");
                    for (String web: item
                    ) {
                        count++;
                        if (count > 3)
                        {
                            break;
                        }
                        str.add(web);
                    }
                    if(!result.contains(str.toString()))
                    {
                        result.add(str.toString());
                    }

                }
            }
            else
            {
                StringJoiner str = new StringJoiner(",");
                for (String item: this.website
                     ) {
                    str.add(item);
                }
                result.add(str.toString());
            }

            this.all = new ArrayList<>(result);
        }

        private List<List<String>> permCalc(List<String> website) {
            List<List<String>> result = new ArrayList<>();
            List<List<String>> res = new ArrayList<>();

            result.add(new ArrayList<>());

            for (int i = 0; i < website.size(); i++) {
                int n = result.size();

                for (int j = 0; j < n; j++) {
                    List<String> oldPerm = result.get(j);

                    for (int k = 0; k <= oldPerm.size() ; k++) {
                        List<String> newPerm = new ArrayList<>(oldPerm);
                        newPerm.add(k, website.get(i));
                        if (newPerm.size() == website.size())
                        {
                            res.add(newPerm);
                        }
                        else
                        {
                            result.add(newPerm);
                        }
                    }

                }
            }
            return res;
        }


    }
}
