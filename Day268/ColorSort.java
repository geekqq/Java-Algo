package Day268;

import static Day256.PrintArray.printArray;
import static Day256.RandomArray.randomArray;
import static Day37.SortedArray.swap;

public class ColorSort {

    public static void colorSort(int[] nums) {
        int i = 0;
        int j = 0;
        int k = nums.length - 1;
        while (i <= k) {
            if (nums[i] == 0) {
                swap(nums, i++, j++);
            } else if (nums[i] == 1) {
                i++;
            } else if (nums[i] == 2){
                swap(nums, i, k--);
            }
        }
    }

    public static void main(String[] args) {
        int[] color = randomArray(10, 2);
        printArray(color);
        colorSort(color);
        printArray(color);
    }
}
