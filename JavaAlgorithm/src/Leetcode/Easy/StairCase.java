package Leetcode.Easy;

//possible ways are there to reach the top of the staircase, given that,
// at every step you can either take 1 step, 2 steps, or 3 steps
public class StairCase {
    public static void main(String[] args) {
        System.out.println(Calculate(4));
    }

    private static int Calculate(int num)
    {
        if (num == 0)
        {
            return 1;
        }
        if (num == 1)
        {
            return 1;
        }
        if (num == 2)
        {
            return 2;
        }

        int step1 = Calculate(num-1);
        int step2 = Calculate(num-2);
        int step3 = Calculate(num-3);

        return step1+step2+step3;
    }
}
