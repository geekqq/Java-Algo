package Day292;

public class LC121BestTimeToBuyAndSellStock {

    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int buy = -prices[0];
        int sell = 0;
        for (int i = 1; i < prices.length; i++) {
            int nextBuy = Math.max(buy, -prices[i]);
            int nextSell = Math.max(sell, buy + prices[i]);
            buy = nextBuy;
            sell = nextSell;
        }
        return sell;
    }

    public static int maxProfitI(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int max = 0;
        int buy = 0;
        int sell = 1;
        while (sell < prices.length) {
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
        System.out.println(maxProfitI(prices));
    }
}
