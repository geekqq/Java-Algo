package Day295;

public class BestTimeBuySellStocks {

    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int buy = 0;
        int sell = 1;
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[buy] < prices[sell]) {
                int profit = prices[sell] - prices[buy];
                max = Math.max(max, profit);
            } else {
                buy = sell;
            }
            sell++;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }
}
