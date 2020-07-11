package Leetcode.Medium;

public class CeilingNumber {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 5, 7};
        int key = 4;
        System.out.println(Calculate(arr, key));
    }


    private static int Calculate(int[] arr, int key) {
        if (key > arr[arr.length-1])
        {
            return -1;
        }

        int start = 0, end = arr.length-1;
        while (start <= end)
        {
            int mid = start + (end-start)/2;
            if (arr[mid] == key)
            {
                return mid;
            }
            if (key < arr[mid])
            {
                end = mid-1;
            }
            else
            {
                start = mid+1;
            }
        }
        return start;
    }
    // you can also get the floor of the number from the below codings

    public static int findFloor(int[] arr, int x) // Function to find floor of x in a sorted array arr[]
    {
        int left = 0, right = arr.length - 1;
        int floor = -1; // initialize floor to -1, if -1 is returned as it is, then floor doesnot exit!
        while (left <= right) {

            int mid = (left + right) / 2; // find the middle value
            if (arr[mid] == x) // if x is equal to mid element, it is the floor value
                return arr[mid];
            else if (x < arr[mid]) // if x is less than the mid element, floor exists in the left subArr[left...mid-1]
                right = mid - 1;
            else // if x is more than the mid element, floor exists in the right subArr[mid...right].
            {
                floor = arr[mid];
                left = mid + 1;
            }
        }
        return floor;
    }

    public static int findCeiling(int[] arr, int x) // Function to find ceiling of input x in a sorted array
    {
        int left = 0, right = arr.length - 1;
        int ceil = -1; // initialize ceiling value to -1, if -1 is returned as it is, then ceil doesnot exit!

        while (left <= right) {

            int mid = (left + right) / 2; // find the middle value
            if (arr[mid] == x) // if x is equal to middle element, it is the ceiling
                return arr[mid];
            else if (x < arr[mid]) // if x is less than the mid element, ceil exists in the left subArray[left...mid-1]
            {
                ceil = arr[mid];
                right = mid - 1;
            } else // if x is more than the mid element, ceil exists in the right subArr[mid...right]

                left = mid + 1;
        }
        return ceil;
    }
}
