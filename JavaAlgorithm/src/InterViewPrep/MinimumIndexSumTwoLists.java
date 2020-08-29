package InterViewPrep;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MinimumIndexSumTwoLists {
    public static void main(String[] args) {
        //String[] str1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
        //String[] str2 = {"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"};
        String[] str1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] str2 = {"KFC", "Shogun", "Burger King"};
        System.out.println(Calculate(str1, str2));
    }

    private static List<String> Calculate(String[] str1, String[] str2)
    {
        int i1 = -1 , i2 = -1, minIdx = Integer.MAX_VALUE;
        List<String> result = new ArrayList<>();

        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < str1.length; i++) {
            map.put(str1[i], i);
        }

        for (int i = 0; i < str2.length; i++) {
            if (map.containsKey(str2[i]))
            {
                i1 = map.get(str2[i]);
                i2 = i;

                if (minIdx > Math.abs(i2+i1))
                {
                    result.clear();
                    minIdx = Math.abs(i2+i1);
                    result.add(str2[i]);
                }
                else if (minIdx == Math.abs(i2+i1))
                {
                    result.add(str2[i]);
                }
            }
        }

        return result;
    }
}
