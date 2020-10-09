package InterViewPrep;

public class LongestPeak {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 2, 1, 1};
        System.out.println(Calculate(arr));
    }

    public static int Calculate(int[] array) {
        int i = 1;
        int longest = 0;

        while (i < array.length - 1)
        {
            boolean isPeak = array[i-1] < array[i] && array[i] > array[i+1];
            if (!isPeak)
            {
                i++;
                continue;
            }

            int leftIdx = i - 2;
            while(leftIdx >= 0 && array[leftIdx] < array[leftIdx+1])
            {
                leftIdx--;
            }

            int rightIdx = i + 2;
            while(rightIdx < array.length && array[rightIdx] < array[rightIdx-1])
            {
                rightIdx++;
            }

            if(longest < rightIdx-leftIdx-1)
            {
                longest = rightIdx-leftIdx-1;
            }

            i= rightIdx;
        }

        return longest;
    }
}
