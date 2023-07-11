package Day257;

import static Day256.PrintArray.printArray;
import static Day37.SortedArray.swap;

public class MoveZeroToEnd {

    public static void moveZero(int[] nums) {
        int zero = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0 && nums[zero] == 0) {
                swap(nums, i, zero);
            }
            if (nums[zero] != 0) {
                zero++;
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
        int[] nums = {0, 8, 0, 2, 0, 3 ,0, 4, 5};
        moveZeroI(nums);
        printArray(nums);
    }
}
