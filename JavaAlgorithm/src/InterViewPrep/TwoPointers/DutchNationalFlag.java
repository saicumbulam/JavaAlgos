/*
Input: [1, 0, 2, 1, 0]
Output: [0 0 1 1 2]
* */
package InterViewPrep.TwoPointers;

public class DutchNationalFlag {
    public static void main(String[] args) {
        //int[] arr = {1, 0, 2, 1, 0};
        int[] arr = {2, 2, 0, 1, 2, 0};
        int[] result = Calculate(arr);

        for (int item: result
             ) {
            System.out.println(item);
        }
    }

    private static int[] Calculate(int[] arr)
    { //[0,0,1,1,2]
        int i = 0;
        int left = 0, right = arr.length-1;

        while (i < arr.length && i <= right) // stop the i at the high to avoid over shift problem
        {
            if (arr[i] == 0)
            {
                Swap(arr,i,left);
                left++;
                i++;
            }
            else if (arr[i] == 1)
            {
                i++;
            }
            else
            {
                Swap(arr,i,right);
                right--;
            }
        }
        return arr;
    }

    private static void Swap(int[] arr, int i1, int i2)
    {
        int temp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = temp;
    }
}
