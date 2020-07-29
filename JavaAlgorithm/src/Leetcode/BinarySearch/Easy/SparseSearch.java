package Leetcode.BinarySearch.Easy;

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

        System.out.println(Calculate(array, 0, array.length - 1, "educative"));
    }

    private static int Calculate(String[] arr, int low, int high, String target)
    {
        if (low > high)
            return -1;
        //calculating mid value
        int mid = (low + high) / 2;

        // Our modification
        if (arr[mid] == "") {
            int i = mid - 1;
            int j = mid + 1;
            while (true) {
                if (i < low && j > high)
                    return -1;

                if (i >= low && arr[i] != "") {
                    mid = i;
                    break;
                } else if (j <= high && arr[j] != "") {
                    mid = j;
                    break;
                }
                i--;
                j++;
            }
        }

        // Now perform simple Binary Search
        if (arr[mid].equals(target))
            return mid;
        else if (arr[mid].compareTo(target) > 0)
            return Calculate(arr, low, mid - 1, target);
        else
            return Calculate(arr, mid + 1, high, target);
    }

}
