package Day280;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static Day256.PrintArray.printArray;
import static Day265.generateRandomArrayWithoutDuplicates.generateArrayWithoutDuplicates;

public class ThreeSum {

    public static void threeSum(int[] arr, int target) {
        if (arr == null || arr.length == 0) throw new IllegalArgumentException();
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 2; i++) {
            int j = i + 1;
            int k = arr.length - 1;
            while (j < k) {
                int sum = arr[i] + arr[j] + arr[k];
                if (sum == target) {
                    System.out.println(arr[i] + "," + arr[j] + "," + arr[k]);
                    j++;
                    k--;
                } else if (sum < target) {
                    j++;
                } else {
                    k--;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = generateArrayWithoutDuplicates(10, 5, 15);
        printArray(arr);
        int target = 30;
        threeSum(arr, target);
    }
}
