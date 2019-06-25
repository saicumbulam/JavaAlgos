package Algorithms.Array;

import java.util.List;

public class ComputeMaxProfit {
    public static double computeMax(List<Double> prices){
        double minPrice = Double.MAX_VALUE, maxProfit=0.0;

        for (Double price: prices
             ) {
            maxProfit = Math.max(maxProfit, price-minPrice);
            minPrice = Math.min(minPrice,price);
        }
        return maxProfit;
    }
    public static void main(String[] args) {

    }
}
