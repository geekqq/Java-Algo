package Day320;

import java.util.*;

import static Day256.PrintArray.printArray;
import static Day256.RandomArray.randomArray;

public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] arr, int target) {
        //cc
        Set<List<Integer>> res = new HashSet<>();
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 2; i++) {
            int j = i + 1;
            int k = arr.length - 1;
            while (j < k) {
                int sum = arr[i] + arr[j] + arr[k];
                if (sum == target) res.add(Arrays.asList(arr[i], arr[j++], arr[k--]));
                else if (sum < target) j++;
                else k--;
            }
        }
        return new ArrayList<>(res);
    }

    public static List<List<Integer>> threeSumFor(int[] arr, int target) {
        //cc
        Set<List<Integer>> res = new HashSet<>();
        for (int i = 0; i < arr.length - 2; i++) {
            for (int j = i + 1; j < arr.length - 1; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    if (arr[i] + arr[j] + arr[k] == target) res.add(Arrays.asList(arr[i], arr[j], arr[k]));
                }
            }
        }
        return new ArrayList<>(res);
    }

    public static void main(String[] args) {
        int[] arr = randomArray(10, 15);
        printArray(arr);
        System.out.println(threeSum(arr, 20));
        System.out.println(threeSumFor(arr, 20));
    }
}
