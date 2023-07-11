package Day257;

import static Day254.SelectSort.generateRandomArrayWithoutDuplicates;
import static Day256.PrintArray.printArray;
import static Day257.InsertSort.insertSort;

public class BinarySearch {

    public static int bs(int[] nums, int t) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int m = l + r >> 1;
            if (nums[m] < t) l = m + 1;
            else if (nums[m] > t) r = m - 1;
            else return m;
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] nums = generateRandomArrayWithoutDuplicates(10, 2, 18);
        printArray(nums);
        insertSort(nums);
        printArray(nums);
        for (int i = 0; i < 20; i++) {
            System.out.println(i + " = " + bs(nums, i) + " ");
        }
    }
}
