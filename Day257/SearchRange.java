package Day257;

import static Day256.PrintArray.printArray;
import static Day256.RandomArray.bubbleSort;
import static Day256.RandomArray.randomArray;

public class SearchRange {

    public static int[] searchRange(int[] nums, int t){
        int[] res = new int[2];
        res[0] = findLeftIndex(nums, t);
        res[1] = findRightIndex(nums, t);
        return res;
    }

    private static int findLeftIndex(int[] nums, int t) {
        int index = -1;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int m = left + (right - left) / 2;
            if (nums[m] >= t) {
                right = m - 1;
            } else {
                left = m + 1;
            }
            if (nums[m] == t) {
                index = m;
            }
        }
        return index;
    }

    private static int findRightIndex(int[] nums, int t) {
        int index = -1;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int m = left + (right - left) / 2;
            if (nums[m] <= t) {
                left = m + 1;
            } else {
                right = m - 1;
            }
            if (nums[m] == t) {
                index = m;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] nums = randomArray(10, 12);
        printArray(nums);
        bubbleSort(nums);
        printArray(nums);
        System.out.println("+++++++++++++++++++");
        int[] arr = {0 ,1 ,2, 4, 4, 4, 6, 7, 8, 9, 9};
        int[] range = searchRange(arr, 9);
        printArray(range);
    }
}
