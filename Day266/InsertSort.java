package Day266;

public class InsertSort {

    public static void insertSort(int[] nums) {
        if (nums == null || nums.length == 0)return;
        for (int i = 1; i < nums.length; i++) {
            int temp = nums[i];
            int j = i - 1;
            while (j >= 0 && temp < nums[j]) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = temp;
        }
    }
}
