package InterViewPrep;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {
    public static void main(String[] args) {
        //int[] arr = {10,2};
        int[] arr = {3,30,34,5,9};
        System.out.println(Calculate(arr));
    }

    private static String Calculate(int[] arr)
    {
        String[] strs =  new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            strs[i] = String.valueOf(arr[i]);
        }

        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2);
            }
        });

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < strs.length; i++) {
            result.append(strs[i]);
        }

        return result.toString();
    }
}
