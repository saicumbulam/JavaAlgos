/*
Easy
* */
package Leetcode.Array.Alter;

public class BestTimeBuySellStock1 {
    public static void main(String[] args) {
        int[] arr = new int[]{7,1,5,3,6,4};

        int current_buy = arr[0];
        int global_sell = arr[1];
        int global_profit = global_sell - current_buy;

        int current_profit;

        for (int i = 1; i < arr.length; i++) {
            current_profit = arr[i] - current_buy;
            if(current_profit > global_profit)
            {
                global_profit = current_profit;
                global_sell = arr[i];
            }

            if(current_buy > arr[i])
            {
                current_buy = arr[i];
            }
        }

        System.out.println(global_profit);
    }
}
