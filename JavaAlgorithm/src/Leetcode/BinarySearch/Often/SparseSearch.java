/*
1. Perform binary search to find the element.
2. If the mid element is "", then make i = mid-1
   and j = mid+1.
   do while to traverse i and j btw left and right.
   if i or j sees a word, then break the loop and continue binary search.
* */
package Leetcode.BinarySearch.Often;

public class SparseSearch {
    public static void main(String[] args) {
        String[] array = {
                "",
                "educative",
                "",
                "",
                "",
                "hello",
                "",
                "learning",
                "world",
                "",
                "",
                ""
        };

        System.out.println(Calculater(array, "educative"));
    }

    private static int Calculater(String[] arr, String target)
    {
        int left = 0, right = arr.length-1;

        while (left <= right)
        {
            int mid = left + (right - left)/2;

            if (arr[mid].equals("")) {
                int i = mid - 1;
                int j = mid + 1;

                while (true) {
                    if (i < left || j > right) {
                        return -1;
                    }
                    if (i >= left && !arr[i].equals("")) {
                        mid = i;
                        break;
                    }
                    if (j <= right && !arr[j].equals("")) {
                        mid = j;
                        break;
                    }
                    i--;
                    j++;
                }
            }

            if (arr[mid].equals(target))
            {
                return mid;
            }

            if (arr[mid].compareTo(target) > 0)
            {
                right = mid-1;
            }
            else if (arr[mid].compareTo(target) < 0)
            {
                left = mid + 1;
            }
        }
        return -1;
    }

}
