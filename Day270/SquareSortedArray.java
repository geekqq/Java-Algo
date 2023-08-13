package Day270;

import java.util.Arrays;
import java.util.Collections;

import static Day256.PrintArray.printArray;

public class SquareSortedArray {

    public static int[] squareSortedArray(int[] nums) {
        if (nums == null || nums.length == 0) return nums;
        int[] newArr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            newArr[i] = (int) Math.pow(nums[i], 2);
        }
        Arrays.sort(newArr);
        return newArr;
    }

    public static int[] sortedSquareArray(int[] arr) {
        if (arr == null || arr.length == 0) return null;
        int i = 0;
        int n = arr.length;
        int j = n - 1;
        int[] res = new int[n];
        for (int k = n - 1; k >= 0; k--) {
            if (Math.abs(arr[i]) > Math.abs(arr[j])) {
                res[k] = arr[i] * arr[i];
                i++;
            } else {
                res[k] = arr[j] * arr[j];
                j--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {-4, -1, 0, 3, 10};
        int[] newArr = sortedSquareArray(arr);
        printArray(newArr);
    }
}
