package InterViewPrep;

import java.math.BigInteger;

public class AddBinary {
    public static void main(String[] args) {
        System.out.println(Calculate("11", "1"));
    }

    public static String Calculate(String a, String b) {
        BigInteger x = new BigInteger(a, 2);
        BigInteger y = new BigInteger(b, 2);
        BigInteger zero = new BigInteger("0", 2);
        BigInteger ans, carry;

        while (y.compareTo(zero) != 0)
        {
            carry = x.and(y);
            ans = x.xor(y);
            x = ans;
            y = carry.shiftLeft(1);
        }

        return x.toString(2);
    }
}
