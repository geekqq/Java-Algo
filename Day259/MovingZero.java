package Day259;

import static Day256.PrintArray.printArray;
import static Day37.SortedArray.swap;

public class MovingZero {

    public static void moveZero(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0 && nums[j] == 0) {
                swap(nums, i, j);
            }
            if (nums[j] != 0) {
                j++;
            }
        }
    }

    public static void moveZeroI(int[] nums) {
        int zero = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                swap(nums, i, zero++);
            }
        }
    }
    public static void main(String[] args) {
        int[] nums = {0, 2, 0, 3,1, 4,5, 0};
        moveZero(nums);
        printArray(nums);
    }
}
