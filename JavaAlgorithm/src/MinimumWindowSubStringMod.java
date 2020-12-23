import java.util.HashMap;

public class MinimumWindowSubStringMod {
    public static void main(String[] args) {
        String str = "azABaabza";
        //returns “ABaab”
        System.out.println(Calculate(str));
    }

    private static String Calculate(String str)
    {
        int t = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            if(Character.isUpperCase(str.charAt(i)))
            {
                char ch = str.charAt(i);
                t++;
                map.put(ch, map.getOrDefault(ch, 0)+1);
            }
        }

        for (int i = 0; i < str.length(); i++) {
            if(map.containsKey(Character.toUpperCase(str.charAt(i))))
            {
                char ch = str.charAt(i);
                t++;
                map.put(ch, map.getOrDefault(ch, 0)+1);
            }
        }
        int matched = 0;
        int windowStart = 0;
        int minLength = str.length()+1;
        int subStrStart = 0;

        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightchar = str.charAt(windowEnd);
            if(map.containsKey(rightchar))
            {
                map.put(rightchar, map.get(rightchar) - 1);
                if (map.get(rightchar) >= 0)
                {
                    matched++;
                }
            }

            while (matched == map.size())
            {
                if (windowEnd - windowStart + 1 < minLength)
                {
                    minLength = windowEnd - windowStart + 1;
                    subStrStart = windowStart;
                }

                char leftchar = str.charAt(windowStart++);
                if (map.containsKey(leftchar))
                {
                    if (map.get(leftchar) == 0) matched--;
                    map.put(leftchar, map.get(leftchar) + 1);
                }
            }

        }

        return minLength == str.length()+1? null : str.substring(subStrStart, subStrStart+minLength);
    }
}
