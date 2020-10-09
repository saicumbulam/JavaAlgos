package InterViewPrep;

public class MonotonicArray {
    public static void main(String[] args) {
        int[] arr = {-1, -5, -10, -1100, -1100, -1101, -1102, -9001};
        System.out.println(Calculate(arr));
    }

    public static boolean Calculate(int[] array) {
        boolean increase = true;
        boolean decrease = true;

        for (int i = 1; i < array.length; i++)
        {
            if(array[i-1] > array[i])
            {
                increase = false;
            }
            if(array[i-1] < array[i])
            {
                decrease = false;
            }
        }

        return increase || decrease;
    }

}
