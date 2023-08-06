package Day266;

import static Day254.SelectSort.generateRandomArrayWithoutDuplicates;
import static Day256.PrintArray.printArray;

public class SearchArray {

    public static int search(int[] nums, int k) {
        if (nums == null || nums.length == 0) return -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == k) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = generateRandomArrayWithoutDuplicates(10, 5, 18);
        printArray(nums);
        System.out.println(search(nums, 10));
    }
}
