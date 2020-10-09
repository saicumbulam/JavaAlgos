package InterViewPrep;

import java.util.Arrays;
import java.util.HashSet;

public class TwoSum {
    public static void main(String[] args) {
        int[] arr = {3,5,-4,8,11,1,-1,6};
        int targetSum = 10;
        int[] result = Calculate(arr, targetSum);
        result = CalculateMaps(arr, targetSum);
        for (int item: result)
        {
            System.out.println(item);
        }
    }

    private static int[] Calculate(int[] arr, int targetSum) {
        int[] result = new int[2];
        Arrays.sort(arr);
        int left =0 , right = arr.length-1;

        while (left < right)
        {
            int currentSum = arr[left] + arr[right];
            if(currentSum > targetSum)
            {
                right--;
            }
            else if(currentSum < targetSum){
                left++;
            }
            else
            {
                result[0] = arr[left];
                result[1] = arr[right];
                break;
            }
        }

        return result;
    }

    private static int[] CalculateMaps(int[] arr, int targetSum) {
        int[] result = new int[2];
        HashSet<Integer> set = new HashSet<>();

        for (int item: arr) {
            if (set.contains((targetSum - item))) {
                result[0] = (targetSum - item);
                result[1] = item;
                break;
            } else {
                set.add(item);
            }
        }

        return result;
    }


}
