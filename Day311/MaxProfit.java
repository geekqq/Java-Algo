package Day311;

public class MaxProfit {

    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int buy = 0;
        int sell = 1;
        int max = 0;
        while (sell < prices.length) {
            if (prices[buy] < prices[sell]) {
                int profit = prices[sell] - prices[buy];
                max = Math.max(max, profit);
            } else buy = sell;
            sell++;
        }
        return max;
    }

    public static void main(String[] args) {

    }
}
