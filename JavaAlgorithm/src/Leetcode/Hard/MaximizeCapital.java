package Leetcode.Hard;

import java.util.PriorityQueue;

public class MaximizeCapital {
    public static void main(String[] args) {
        int[] capitals = {0,1,2};
        int[] profits = {1,2,3};
        int initCapital = 1;
        int numProj = 2;
        System.out.println(Calculate(capitals, profits, initCapital, numProj));

    }

    private static int Calculate(int[] capitals, int[] profits, int initCapital, int numProj) {
        PriorityQueue<Integer> minCapital = new PriorityQueue<>((a, b) -> capitals[a] - capitals[b]);
        PriorityQueue<Integer> maxProfit = new PriorityQueue<>((a, b) -> profits[b] - profits[a]);

        for (int i = 0; i < capitals.length; i++) {
            minCapital.add(i);
        }

        int avialCapital = initCapital;
        for (int i = 0; i < numProj; i++) {
            while (!minCapital.isEmpty() && capitals[minCapital.peek()] <= avialCapital)
            {
                maxProfit.add(minCapital.poll());
            }

            if (maxProfit.isEmpty())
            {
                break;
            }

            avialCapital += profits[maxProfit.poll()];
        }

        return avialCapital;

    }


}
