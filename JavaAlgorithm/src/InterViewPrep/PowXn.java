/*
x^2n = (x^n)^2.
This is the fasteest way to get the power.
*/
package InterViewPrep;

public class PowXn {
    public static void main(String[] args) {
        double x = 2.00000;
        int n = 10;
        System.out.println(Calculate(x, n));
    }

    private static double Calculate(double x, int n)
    {
        if (n == 0)
        {
            return 1;
        }
        double x1 = Calculate(x, n/2);
        if (n % 2 == 0)
        {
            return x1 * x1;
        }
        else
        {
            return x * x1 * x1;
        }
    }
}
