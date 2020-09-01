package InterViewPrep;

public class CountPrimes {
    public static void main(String[] args) {
        int x = 10;
        System.out.println(CalculateInt(x));
        System.out.println(CalculatePrec(x, 3));
    }

    private static int CalculateInt(int x)
    {
        int left = 0, right = x/2, ans = 0;
        while (left <= right)
        {
            int mid = left + (right-left)/2;
            if(mid*mid == x)
            {
                return mid;
            }
            if(mid*mid < x)
            {
                left = mid+1;
                ans = mid;
            }
            else
            {
                right = mid - 1;
            }
        }

        return ans;
    }


    private static float CalculatePrec(int x, int precision)
    {
        int left = 2, right = x/2;
        float ans = (float) 0.0;

        while (left <= right)
        {
            int mid = left + (right - left)/2;
            if(mid*mid == x)
            {
                return mid;
            }

            if(mid * mid < x)
            {
                left = mid+1;
                ans = mid;
            }
            else
            {
                right = mid-1;
            }
        }

        float increment = (float) 0.1;
        for (int i = 0; i < precision; i++) {
            while (ans * ans <= x)
            {
                ans += increment;
            }

            ans -= increment;
            increment = increment/10;
        }

        return ans;

    }
}
