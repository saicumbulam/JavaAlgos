/*
Input: [2, 3, 3, 3, 6, 9, 9]
Output: 4
Explanation: The first four elements after
removing the duplicates will be [2, 3, 6, 9].

Time : O(N)
Space: O(1)
* */
package InterViewPrep.TwoPointers;

public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] arr = {2, 3, 3, 3, 6, 9, 9};
        System.out.println(Calculate(arr));
    }

    private static int Calculate(int[] arr)
    {
        int index = 1;

        for (int i = 1; i < arr.length; i++) {
            if(arr[i] != arr[i-1])
            {
                arr[index++] = arr[i];
            }
        }

        return index;
    }
}
