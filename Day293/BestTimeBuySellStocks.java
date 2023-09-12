package Day293;

public class BestTimeBuySellStocks {

    public static int maxProfit(int[] arr) {
        if (arr == null || arr.length == 0) return 0;
        int buy = 0;
        int sell = 1;
        int max = 0;
        while (sell < arr.length) {
            if (arr[buy] < arr[sell]) {
                int profit  = arr[sell] - arr[buy];
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
