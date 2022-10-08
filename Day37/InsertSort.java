package Day37;

public class InsertSort {
    public static void main(String[] args) {
        int[] nums = {4,9,3,0,-1,7};
        insertSort(nums);
        for (int i : nums) {
            System.out.print(i + " ");
        }
    }

    public static int[] insertSort(int[] nums) {
        //corner case
        if (nums == null || nums.length <= 1) return nums;

        //initiate minIndex, with two pointers i and j
        int minIndex;
        for (int i = 0; i < nums.length - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }
            swap(nums, minIndex, i);
        }
        return nums;
    }

    public static int[] swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        return nums;
    }
}
