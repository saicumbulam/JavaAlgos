/*
Psuedo:
1. Iterate through the bit string of the input integer, from right to left (i.e. n = n >> 1).
   To retrieve the right-most bit of an integer, we apply the bit AND operation (n & 1).

2. For each bit, we reverse it to the correct position (i.e. (n & 1) << power).
   Then we accumulate this reversed bit to the final result.

3. When there is no more bits of one left (i.e. n == 0), we terminate the iteration.

* */
package Leetcode.BitWise.Easy.Often;

public class ReverseBits {
    public static int Calculate(int n)
    {
        int ret = 0;
        int power = 31;
        while (n != 0)
        {
            ret += (n&1) << power; //accumulate result in ret
            n = (n >> 1); //Iterate the n string from right most digit
            power--;  //reduce the power
        }

        return ret;
    }
}
