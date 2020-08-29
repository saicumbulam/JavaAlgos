package InterViewPrep;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    static List<List<String>> result = new ArrayList<>();

    public static void main(String[] args) {
        String str = "aab";
        Calculate(str, 0, str.length()-1, new ArrayList<>());
        System.out.println(result);
    }

    private static void Calculate(String str, int start, int end, List<String> curr)
    {
        if (start == str.length())
        {
            result.add(new ArrayList<>(curr));
            return;
        }

        for (int i = start; i <= end; i++) {
            if (isPalindrome(str, start, i))
            {
                curr.add(str.substring(start, i+1));
                Calculate(str, i+1, end, curr);
                curr.remove(curr.size()-1);
            }
        }
    }

    private static boolean isPalindrome(String str, int left, int right)
    {
        while (left < right)
        {
            if (str.charAt(left) == str.charAt(right))
            {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
