/*
Given a staircase with ‘n’ steps and an array of
‘n’ numbers representing the fee that you have to
pay if you take the step.
Implement a method to calculate the minimum fee
required to reach the top of the staircase (beyond the top-most step).

Number of stairs (n) : 6
Fee: {1,2,5,2,1,2}
Output: 3
Explanation: Starting from index '0', we can reach the top through: 0->3->top
The total fee we have to pay will be (1+2).
* */
package Leetcode.Dynamic.Often;

public class MinimumFeeJumps {
    public static void main(String[] args) {
        int[] fee = {1,2,5,2,1,2};
        System.out.println(Calculate(fee, 0));
    }

    private static int Calculate(int[] fee, int currIndex)
    {
        if (currIndex >= fee.length)
        {
            return 0;
        }

        int step1 = Calculate(fee, currIndex+1);
        int step2 = Calculate(fee, currIndex+2);
        int step3 = Calculate(fee, currIndex+3);

        int min = Math.min(step1, Math.min(step2, step3));
        return min + fee[currIndex];
    }
}
