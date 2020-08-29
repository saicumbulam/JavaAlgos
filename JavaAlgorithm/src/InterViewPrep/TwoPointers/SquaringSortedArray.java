/*
Input: [-2, -1, 0, 2, 3]
Output: [0, 1, 4, 4, 9]

Time : O(N)
Space: O(N)
* */
package InterViewPrep.TwoPointers;

public class SquaringSortedArray {
    public static void main(String[] args) {
        int[] arr = {-2, -1, 0, 2, 3};
        int[] result = Calculate(arr);

        for (int item: result
             ) {
            System.out.println(item);
        }
    }

    private static int[] Calculate(int[] arr)
    {
        int[] result = new int[arr.length];
        int index = arr.length-1;
        int left = 0, right = arr.length-1;
        while (left <= right)
        {
            int leftSquare = arr[left] * arr[left];
            int rightSquare = arr[right] * arr[right];
            if (leftSquare < rightSquare)
            {
                result[index--] = rightSquare;
                right--;
            }
            else
            {
                result[index--] = leftSquare;
                left++;
            }
        }

        return result;
    }
}
