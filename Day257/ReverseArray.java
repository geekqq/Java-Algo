package Day257;

import static Day256.RandomArray.randomArray;
import static Day37.MergeSortTwo.printArray;
import static Day37.SortedArray.swap;

public class ReverseArray {

    public static void reverseArray(int[] nums) {

        int left =  0;
        int right = nums.length - 1;
        while (left < right) {
            swap(nums, left++, right--);
        }
    }

    public static void main(String[] args) {
        int[] nums = randomArray(7, 10);
        printArray(nums);
        reverseArray(nums);
        printArray(nums);
    }
}
