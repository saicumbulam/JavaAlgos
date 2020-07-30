/*
This is a binary search withe arr[mid] == element, check removed.
* */
package Leetcode.BinarySearch.Easy;

public class NextLetter {
    public static void main(String[] args) {
        char[] charArray = {'a','c','f','h'};
        char target = 'f';
        System.out.println(Calculate(charArray, target));
    }

    private static char Calculate(char[] chars, char target)
    {
        int left = 0, right = chars.length-1;
        if (chars[left] > target || target > chars[right])
        {
            return chars[0];
        }

        while (left < right)
        {
            int mid = left + (right-left)/2;
            if (chars[mid] > target)
            {
                right = mid-1;
            }
            else
            {
                left = mid+1;
            }
        }

        return chars[left];
    }
}
