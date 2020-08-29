/*
find a triplet in the array whose sum is as close to the target number as possible, return the sum of the triplet

Input: [-2, 0, 1, 2], target=2
Output: 1
Explanation: The triplet [-2, 1, 2] has the closest sum to the target.

Time complexity: O(N^2)
Space complexity: O(N)
* */
package InterViewPrep.TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TripletsSumClosestTarget {
    public static void main(String[] args) {
        int[] arr = {-2, 0, 1, 2};
        int target = 2;
        System.out.println(Calculate(arr, target));
    }

    private static int Calculate(int[] arr, int target)
    {
        int smallest = Integer.MAX_VALUE;
        List<Integer> result = new ArrayList<>();

        Arrays.sort(arr);

        for (int i = 0; i < arr.length-2; i++) {
            int left = i+1;
            int right = arr.length-1;

            while (left < right)
            {
                int targetDiff =target - arr[left] + arr[right] + arr[i];
                if (targetDiff == 0)
                {
                    result.add(arr[left]);
                    result.add(arr[right]);
                    result.add(arr[i]);
                    System.out.println(result);
                    return target - targetDiff;
                }

                if (Math.abs(smallest) > Math.abs(targetDiff) ||
                        (Math.abs(smallest) == Math.abs(targetDiff) && targetDiff < smallest))
                {

                    smallest = targetDiff;
                    result.clear();
                    result.add(arr[left]);
                    result.add(arr[right]);
                    result.add(arr[i]);
                }

                if (targetDiff > 0)
                {
                    left++;
                }
                else
                {
                    right--;
                }
            }
        }
        System.out.println(result);
        return target - smallest;
    }
}
