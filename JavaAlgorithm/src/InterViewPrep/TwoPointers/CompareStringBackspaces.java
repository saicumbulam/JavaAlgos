/*

Given two strings containing backspaces (identified by the character ‘#’), check if the two strings are equal.

Input: str1="xy#z", str2="xzz#"
Output: true
Explanation: After applying backspaces the strings become "xz" and "xz" respectively.

Time: O(N)
Space: O(1)
* */
package InterViewPrep.TwoPointers;

public class CompareStringBackspaces {
    public static void main(String[] args) {
        String str1 = "xy#z";
        String str2 = "xzz#";

        System.out.println(Calculate(str1, str2));
    }

    private static boolean Calculate(String str1, String str2)
    {
        int index1 = str1.length()-1, index2 = str2.length()-1;
        int i1 = 0, i2 = 0;

        while (index1 >= 0 && index2 >= 0)
        {
            i1 = nextIndex(str1, index1);
            i2 = nextIndex(str2, index2);

            if (i1 < 0 && i2 < 0)
            {
                return true;
            }

            if (i1 < 0 || i2 < 0)
            {
                return false;
            }

            if (str1.charAt(i1) != str2.charAt(i2))
            {
                return false;
            }

            index1 = i1-1;
            index2 = i2-1;
        }

        return true;
    }

    private static int nextIndex(String str, int index)
    {
        int backSpace = 0;
        for (; index < str.length(); index--)
        {
            if (str.charAt(index) == '#')
            {
                backSpace += 1;
            }
            else if (backSpace > 0)
            {
                backSpace--;
            }
            else
            {
                break;
            }
        }
        return index;
    }
}
