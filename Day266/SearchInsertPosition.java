package Day266;

import static Day256.PrintArray.printArray;

public class SearchInsertPosition {

    public static int findKeyOrInsertPosition(int[] nums, int key) {
        if (nums == null || nums.length == 0) return 0;
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == key) return mid;
            if (key < nums[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    //search target in an array, return the target index if found, return the insert position if not found
    public static void main(String[] args) {
        int[] nums = { 1, 3, 5, 6, 8};
        printArray(nums);
        System.out.println(findKeyOrInsertPosition(nums, 7));
    }
}
