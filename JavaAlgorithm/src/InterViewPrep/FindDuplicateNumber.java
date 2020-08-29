package InterViewPrep;

import java.util.Arrays;

public class FindDuplicateNumber {
    public static void main(String[] args) {
        //int[] arr = {1,3,4,2,2};
        int[] arr = {3,1,3,4,2};
        System.out.println(Calculate(arr));
    }

    private static int Calculate(int[] arr)
    {
        int slow = arr[0], fast = arr[0];

        do {
            slow = arr[slow];
            fast = arr[arr[fast]];
        } while (slow != fast);

        slow = arr[0];

        while (slow != fast)
        {
            slow = arr[slow];
            fast = arr[fast];
        }

        return fast;
    }
}
