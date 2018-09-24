public class StockPrice {

    int[] stockPrices = new int[]{10, 7, 5, 8, 11, 9};

    public static int getMaxProfit(int[] stockPrices) {
        if (stockPrices.length < 2) {
            throw new RuntimeException();
        }
        int buyPrice = Integer.MAX_VALUE;
        int sellPrice = 0;
        int profit = 0; // if the value goes down all day, I will not sell, so my profit will be 0
        for (int i = 0; i < stockPrices.length; i++) {
            if (stockPrices[i] < buyPrice) {
                buyPrice = stockPrices[i];
            } else if (stockPrices[i] > sellPrice) {
                sellPrice = stockPrices[i];
            }
            profit = Math.max(profit, sellPrice - buyPrice);
        }
        return profit;
    }

    // if we want to return the smallest loss when the price goes down all day
    public static int getMaxProfitReturningNegative(int[] stockPrices) {

        // calculate the max profit
        if (stockPrices.length < 2) {
            throw new RuntimeException();
        }
        int buyPrice = stockPrices[0]; // min price seen so far
        int profit = stockPrices[1] - stockPrices[0];
        for (int i = 1; i < stockPrices.length; i++) {
            profit = Math.max(profit, stockPrices[i] - buyPrice);
            buyPrice = Math.min(stockPrices[i], buyPrice);
        }
        return profit;
    }
}