package InterViewPrep;

import java.util.LinkedList;
import java.util.Queue;

public class ReachNumber {
    public static void main(String[] args) {
        //int target = 3;
        int target = 2;

        System.out.println(Calculate(target));
    }
    // Bfs approach to get the result
    private static int Calculate(int num)
    {
        int count = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        int step = 1;

        while (!queue.isEmpty())
        {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                int polled = queue.poll();
                if (polled == num)
                {
                    return count;
                }
                queue.add(polled+step);
                queue.add(polled-step);
            }
            step++;
            count++;
        }
        return count;
    }
}
