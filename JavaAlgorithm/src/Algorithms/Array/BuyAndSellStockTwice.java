package Algorithms.Array;

import java.util.ArrayList;
import java.util.List;

public class BuyAndSellStockTwice {
    public static double buyNSellStockTwice(List<Double> prices){
        double maxTotalProfit = 0.0;
        List<Double> firstBuySellProfits = new ArrayList<>();
        double minPriceSoFar = Double.MAX_VALUE;

        // Forward phase. For each day record maximum profit, if we sell on that day

        for (int i = 0; i < prices.size(); i++) {
            minPriceSoFar = Math.min(minPriceSoFar, prices.get(i));
            maxTotalProfit = Math.max(maxTotalProfit, prices.get(i) - minPriceSoFar);
            firstBuySellProfits.add(maxTotalProfit);
        }

        //Backward phase. For each day, find the maximum profit if we make second buy
        // on that day

        double maxPricesofar = Double.MIN_VALUE;
        for (int i = prices.size() -1; i > 0 ; i++) {
            maxPricesofar = Math.max(maxPricesofar, prices.get(i));
            maxTotalProfit = Math.max(maxTotalProfit, maxPricesofar-prices.get(i) +
                    firstBuySellProfits.get(i -1));
        }
        return maxTotalProfit;
    }
}
