package Leetcode.SlidingWindow.Easy;

public class ImplementStrStr {
    public static void main(String[] args) {
        String haystack = "hello", needle = "ll";
        System.out.println(Calculate(haystack, needle));
    }

    private static int Calculate(String haystack, String needle)
    {
        if (haystack.equals("") && needle.equals(""))
        {
            return 0;
        }

        if (needle == null || needle.equals(""))
        {
            return 0;
        }

        int windowStart = 0;

        StringBuilder temp = new StringBuilder();

        for(int windowEnd = 0; windowEnd < haystack.length(); windowEnd++)
        {
            temp.append(haystack.charAt(windowEnd));

            if(windowEnd >= needle.length()-1)
            {
                if (temp.toString().equals(needle))
                {
                    return windowStart;
                }
                temp.deleteCharAt(0);
                windowStart++;
            }
        }

        return -1;
    }
}
