package Day252;

import java.util.Collections;
import java.util.List;

public class MinMaxSumDemo {

    public static void minMaxSum(List<Integer> list) {
        if (list == null || list.size() == 0) return;
        Collections.sort(list);
        long max = list.get(list.size() - 1);
        long min = list.get(0);
        long sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(0);
        }
        long maxSum = sum - min;
        long minSum = sum = max;
        System.out.println(minSum + " " + maxSum);
    }

    public static void minMaxSumII(List<Integer> list) {
        if (list == null || list.size() == 0) return;
        long sum = getSum(list);
        long max = findMax(list);
        long min = findMin(list);
        System.out.println((sum - max) + " " + (sum - min));

    }

    private static long findMax(List<Integer> list) {
        long max = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) > max) {
                max = list.get(i);
            }
        }
        return max;
    }

    private static long findMin(List<Integer> list) {
        long min = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) < min) {
                min = list.get(i);
            }
        }
        return min;
    }

    private static long getSum(List<Integer> list) {
        long sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
        }
        return sum;
    }
}
