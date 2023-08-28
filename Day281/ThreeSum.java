package Day281;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static Day256.PrintArray.printArray;
import static Day265.generateRandomArrayWithoutDuplicates.generateArrayWithoutDuplicates;

public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] arr, int target) {
        Arrays.sort(arr);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < arr.length - 2; i++) {
            int j = i + 1;
            int k = arr.length - 1;

            while (j < k) {
                int sum = arr[i] + arr[j] + arr[k];
                List<Integer> list = new ArrayList<>();
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
        int[] arr = generateArrayWithoutDuplicates(10, 5, 15);
        printArray(arr);
        int target = 30;
        threeSum(arr, target);
        System.out.println(threeSum(arr,target));
    }
}
