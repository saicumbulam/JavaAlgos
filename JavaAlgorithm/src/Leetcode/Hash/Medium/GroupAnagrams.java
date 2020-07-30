package Leetcode.Hash.Medium;

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] arr = {"eat", "tea", "tan", "ate", "nat", "bat"};
        HashMap<String, List<String>> hashMap = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            char[] strArray = arr[i].toCharArray();
            Arrays.sort(strArray);
            String str = String.valueOf(strArray);
            if(!hashMap.containsKey(str))
            {
                hashMap.put(str, new ArrayList<>());
            }
            hashMap.get(str).add(arr[i]);
        }
        for (Map.Entry<String, List<String>> map : hashMap.entrySet()) {
            System.out.println(map.getValue());
        }
    }
}
