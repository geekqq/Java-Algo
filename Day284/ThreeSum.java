package Day284;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static Day256.PrintArray.printArray;
import static Day256.RandomArray.randomArray;

public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] arr, int target) {

        List<List<Integer>> res = new LinkedList<>();
        if (arr == null || arr.length == 0) return res;
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 2; i++) {
            int j = i + 1;
            int k = arr.length - 1;
            while (j < k) {
                int sum = arr[i] + arr[j] + arr[k];
                List<Integer> list = new LinkedList<>();
                if (sum == target) {
                    list.add(arr[i]);
                    list.add(arr[j]);
                    list.add(arr[k]);
                    res.add(list);
                    j++;
                    k--;
                } else if (sum < target) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = randomArray(10, 20);
        printArray(arr);
        System.out.println(threeSum(arr, 25));
    }
}
