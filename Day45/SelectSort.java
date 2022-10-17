package Day45;

public class SelectSort {
    public static void main(String[] args) {
        int[] nums = { 10, 7, 8, 9, 1, 5 };
        selectSort(nums);
        printArray(nums);
    }

    public static int[] selectSort(int[] nums) {
        int minIndex;
        for (int i = 0; i < nums.length - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[minIndex] >= nums[j]) {
                    minIndex = j;
                }
            }
            swap(nums, i, minIndex);
        }
        return nums;
    }
    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public static void printArray(int[] nums) {
        for(int n : nums) {
            System.out.print(n + " ");
        }
        System.out.println();
    }
}
