package Day328;

public class BuySellStock {

    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) throw new IllegalArgumentException("invalid input!");
        int buy = 0;
        int sell = 1;
        int maxProfit = 0;
        while (sell < prices.length) {
            if (prices[buy] < prices[sell]) {
                int profit = prices[sell] - prices[buy];
                maxProfit = Math.max(maxProfit, profit);
            } else {
                buy = sell;
            }
            sell++;
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }
}
