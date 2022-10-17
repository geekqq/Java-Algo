package Day45;

public class QuickSort {
    static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    static int partition(int[] nums, int low, int high) {
        //take the last element as pivot
        //low is the starting index, high is the ending index;
        int pivot = nums[high];

        int i = low - 1;
        for (int j = low; j <= high - 1 ; j++) {
            if (nums[j] < pivot) {
                i++;
                swap(nums, i, j);
            }
        }
        swap(nums, i + 1, high);
        return i + 1;
    }

    static void quickSort(int[] nums, int low, int high) {
        if (low < high) {
            //pi is the partition index, arr[pi] is at the right place
            int pi = partition(nums, low, high);
            quickSort(nums, low, pi - 1);
            quickSort(nums, pi + 1, high);
        }
    }

    static void printArray(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] nums = { 10, 7, 8, 9, 1, 5 };
        quickSort(nums, 0, nums.length - 1);
        printArray(nums);
    }
}
