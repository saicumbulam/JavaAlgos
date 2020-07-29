package Leetcode.FastSlow.Medium;

public class FindDuplicateNumber {
    public static void main(String[] args) {
        int[] arr = {1,3,4,2,2};

        int slow = arr[0], fast = arr[0];
        do
        {
            slow = arr[slow];
            fast = arr[arr[fast]];
        } while (slow != fast);

        slow = arr[0];

        while (slow != fast)
        {
            slow = arr[slow];
            fast = arr[fast];
        }
        System.out.println(fast);
    }
}
