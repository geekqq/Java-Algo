package Day51;

public class QuickSort {
    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static int partition(int[] nums, int low, int high) {
        int pivot = nums[high];

        int i = low - 1;
        for (int j = low; j <= high - 1; j++) {
            if (nums[j] < pivot) {
                i++;
                swap(nums, i, j);
            }
        }
        swap(nums, i+ 1, high);
        return i + 1; //此时i+1位置的pivot一定是在sort好的正确的位置上，因为左边的值都小于pivot而右边的值都大于pivot
    }

    public static void quickSort(int[] nums, int low, int high) {
        if (low < high) {
            int pi = partition(nums, low, high);
            quickSort(nums, low, pi - 1);
            quickSort(nums, pi + 1, high);
        }
    }

    public static void printArray(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] nums = {-1,7,2,9,4,6};
        quickSort(nums, 0, nums.length - 1);
        printArray(nums);
    }
}
