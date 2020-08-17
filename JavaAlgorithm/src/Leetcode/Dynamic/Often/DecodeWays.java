package Leetcode.Dynamic.Often;

public class DecodeWays {
    public static void main(String[] args) {
        String str = "226";
        System.out.println(Calculate(str, 0));
    }

    private static int Calculate(String str, int curIdx)
    {
        if (curIdx >= str.length() -1)
        {
            return 1;
        }

        if (str.charAt(curIdx) == '0')
        {
            return 0;
        }

        int ans = Calculate(str, curIdx+1);
        if (Integer.parseInt(str.substring(curIdx, curIdx+2)) <= 26)
        {
            ans += Calculate(str, curIdx+2);
        }

        return ans;
    }
}
