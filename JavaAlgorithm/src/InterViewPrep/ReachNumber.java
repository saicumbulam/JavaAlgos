package InterViewPrep;

import java.util.LinkedList;
import java.util.Queue;

public class ReachNumber {
    public static void main(String[] args) {
        int target = 3;

        System.out.println(Calculate(target));
    }
    private static int Calculate(int target)
    {
        target = Math.abs(target);

        int step = 0;
        int sum = 0;
        while (sum < target) {
            step++;
            sum += step;
        }

        if ((sum - target) %2 != 0)
        {
            step++;
            sum += step;
        }

        return step;
    }
}
