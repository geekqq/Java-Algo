package Day260;

import static Day256.PrintArray.printArray;
import static Day37.SortedArray.swap;

public class MoveZero {

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

    public static void insertSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int key = nums[i];
            int j = i - 1;
            while (j >= 0 && nums[j] > key) {
                nums[j+ 1] = nums[j];
                j--;
            }
            nums[j + 1] = key;
        }
    }

    public static void selectSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[min]) {
                    min = j;
                }
            }
            swap(nums, i, min);
        }
    }

    public static void main(String[] args) {
        int[] nums = {0, 2, 1, 0, 4, 1, 0};
        moveZero(nums);
        printArray(nums);

        selectSort(nums);
        printArray(nums);
    }
}
