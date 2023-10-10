package Day320;

import java.util.Arrays;

public class MaxProfitAssigningWork {

    public static int maxProfit(int[] difficulty, int[] profit, int[] workers) {
        int n = difficulty.length;
        int[][] pairs = new int[n][2];
        for (int i = 0; i < n; i++) {
            pairs[i] = new int[] {difficulty[i], profit[i]};
        }
        Arrays.sort(pairs, (a, b) -> a[0] - b[0]);
        Arrays.sort(workers);

        int curProfit = 0;
        int max = 0;
        int index = 0;
        for (int worker : workers) {
            while (index < n && worker >= pairs[index][0]) {
                curProfit = Math.max(curProfit, pairs[index++][1]);
            }
            max += curProfit;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] difficulty = {2, 4, 6, 8, 10};
        int[] profit = {10, 20, 30, 40, 50};
        int[] worker = {4, 5, 6, 7};
        int[] difficulty1 = {85, 47, 57};
        int[] profit1 = {24, 66, 99};
        int[] worker1 = {40, 25, 25};
        System.out.println(maxProfit(difficulty, profit, worker));
        System.out.println(maxProfit(difficulty1, profit1, worker1));
    }
}
