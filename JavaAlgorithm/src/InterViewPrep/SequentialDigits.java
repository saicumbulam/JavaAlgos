package InterViewPrep;

import java.util.ArrayList;
import java.util.List;

public class SequentialDigits {
    public static void main(String[] args) {
        sequentialDigits(100, 300);
    }
    public static List<Integer> sequentialDigits(int low, int high) {
        String sample = "123456789";
        int n = 10;
        List<Integer> nums = new ArrayList();

        int lowLen = String.valueOf(low).length();
        int highLen = String.valueOf(high).length();
        for (int length = lowLen; length <= highLen; length++) {
            for (int start = 0; start < n - length; ++start) {
                int num = Integer.parseInt(sample.substring(start, start + length));
                if (num >= low && num <= high) nums.add(num);
            }
        }
        return nums;
    }
}
