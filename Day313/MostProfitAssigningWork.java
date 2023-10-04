package Day313;

import java.util.Arrays;

public class MostProfitAssigningWork {

    public static int mostProfitAssigningWork(int[] difficulty, int[] profit, int[] worker) {
        int len = difficulty.length;
        int[][] pairs = new int[len][2];
        for (int i = 0; i < len; i++) {
            pairs[i][0] = difficulty[i];
            pairs[i][1] = profit[i];
        }
        Arrays.sort(pairs, (a, b) -> (a[0] - b[0]));
        Arrays.sort(worker);

        int maxProfit = 0;
        int index = 0;
        int curMaxProfit = 0;
        for (int capability : worker) {
            while (index < len && capability >= pairs[index][0]) {
                curMaxProfit = Math.max(curMaxProfit, pairs[index++][1]);
            }
            maxProfit += curMaxProfit;
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] difficulty = {2, 4, 6, 8, 10};
        int[] profit = {10, 20, 30, 40, 50};
        int[] worker = {4, 5, 6, 7};
        int[] difficulty1 = {85, 47, 57};
        int[] profit1 = {24, 66, 99};
        int[] worker1 = {40, 25, 25};
        System.out.println(mostProfitAssigningWork(difficulty, profit, worker));
        System.out.println(mostProfitAssigningWork(difficulty1, profit1, worker1));
    }
}
