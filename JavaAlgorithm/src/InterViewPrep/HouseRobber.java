package InterViewPrep;

public class HouseRobber {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        System.out.println(Calculate(nums));
    }

    // time: o(n) | space : o(1)
    private static int Calculate(int[] wealth)
    {
        if(wealth.length == 0) return 0;

        int n1 = 0, n2 = wealth[0];
        int temp = 0;

        for (int i = 1; i < wealth.length; i++) {
            temp = Math.max(n1+wealth[i], n2);
            n1 = n2;
            n2 = temp;
        }

        return n2;
    }
}
