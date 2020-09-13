package InterViewPrep;

public class SqrtUptoPrecision {
    public static void main(String[] args) {
        System.out.println(Calculate(5, 3));
    }

    private static double Calculate(double num, int precision)
    {
        if (num < 2)
        {
            return num;
        }

        int left = 2, right = (int)num/2;

        while (left <= right)
        {
            int mid = left + (right - left)/2;
            long pivot = (long) mid * mid;
            if (pivot == num) return (double) pivot;

            if (pivot > num) right = mid-1;
            else left = mid+1;
        }

        double ans = (double) right;
        double decimal = 0.1;
        for (int i = 0; i < precision; i++) {
            while (ans * ans < num)
            {
                ans += decimal;
            }
            ans -= decimal;
            decimal /= 10;
        }

        return ans;
    }
}
