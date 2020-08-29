/*
Input: [1, 2, 3, 4, 6], target=6
Output: [1, 3]
Explanation: The numbers at index 1 and 3 add up to 6: 2+4=6
* */
package InterViewPrep.TwoPointers;

public class PairTargetSum {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 6};
        int target = 6;
        int[] output = Calculate(arr, target);

        for (int item: output
             ) {
            System.out.println(item);
        }
    }


    private static int[] Calculate(int[] arr, int target)
    {
        int left = 0, right = arr.length-1;
        while (left < right)
        {
            int sum = arr[left] + arr[right];
            if (target == sum)
            {
                return new int[]{left, right};
            }

            if (target > sum)
            {
                left++;
            }
            else
            {
                right--;
            }
        }
        return new int[]{-1,-1};
    }
}
