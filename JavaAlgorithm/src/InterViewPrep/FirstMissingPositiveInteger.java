package InterViewPrep;

public class FirstMissingPositiveInteger {
    public static void main(String[] args) {
        int[] arr = {3,4,-1,1};
        System.out.println(Calculate(arr));
    }

    private static int Calculate(int[] arr)
    {
        boolean[] map = new boolean[arr.length+1];

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > 0 && arr[i] <= arr.length)
            {
                map[arr[i]] = true;
            }
        }

        for (int i = 1; i <= arr.length; i++) {
            if(!map[i]) return i;
        }
        return arr.length+1;
    }
}
