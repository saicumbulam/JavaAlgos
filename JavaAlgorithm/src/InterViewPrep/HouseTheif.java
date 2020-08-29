package InterViewPrep;

public class HouseTheif {
    public static void main(String[] args) {
        int[] arr = {2, 5, 1, 3, 6, 2, 4};
        System.out.println(Calculate(arr, 0));
    }

    private static int Calculate(int[] arr, int curIdx)
    {
        if(curIdx >= arr.length)
        {
            return 0;
        }

        int current = arr[curIdx] + Calculate(arr, curIdx+2);
        int skip = Calculate(arr, curIdx+1);

        return Math.max(current, skip);
    }
}
