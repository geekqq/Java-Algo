package Day298;

import Day11.ArrayRank;

import java.util.*;

import static Day256.PrintArray.printArray;
import static Day256.RandomArray.randomArray;

public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] arr, int target) {
        Set<List<Integer>> res = new HashSet<>();
        if (arr == null || arr.length == 0) return null;
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 2; i++) {
            int j = i + 1;
            int k = arr.length - 1;
            while (j < k) {
                int sum = arr[i] + arr[j] + arr[k];
                if (sum == target) {
                    res.add(Arrays.asList(arr[i], arr[j++], arr[k--]));
                } else if (sum < target) j++;
                else k--;
            }
        }
        return new ArrayList<>(res);
    }

    public static void main(String[] args) {
        int[] arr = randomArray(10, 15);
        printArray(arr);
        System.out.println(threeSum(arr, 20));
    }
}
