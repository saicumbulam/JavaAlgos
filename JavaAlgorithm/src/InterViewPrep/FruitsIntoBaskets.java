package InterViewPrep;

import java.util.HashMap;
import java.util.Map;

public class FruitsIntoBaskets {
    public static void main(String[] args) {
        //String[] strs ={"A", "B", "C", "A", "C"};
        String[] strs ={"A", "B", "C", "B", "B", "C"};
        System.out.println(Calculate(strs));
    }

    private static int Calculate(String[] strs)
    {
        HashMap<String, Integer> map = new HashMap<>();
        int windowStart = 0, maxFruits = 0;

        for (int windowEnd = 0; windowEnd < strs.length; windowEnd++) {
            String rightChar = strs[windowEnd];

            map.put(rightChar, map.getOrDefault(rightChar, 0)+1);

            while (map.size() > 2)
            {
                String leftChar = strs[windowStart++];
                if (map.containsKey(leftChar))
                {
                    map.put(leftChar, map.get(leftChar)-1);
                    if (map.get(leftChar) == 0)
                    {
                        map.remove(leftChar);
                    }
                }
            }

            if (map.size() == 2)
            {
                int sum = 0;
                for (Map.Entry<String, Integer> entry: map.entrySet()
                ) {
                    sum += entry.getValue();
                }

                maxFruits = Math.max(maxFruits, sum);
            }
        }

        return maxFruits;
    }
}
