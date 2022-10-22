package Day50;

public class QuickSort {
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    public static int partition(int[] arr, int low, int high) {
        //low and high are the indexes for the array arr.
        // take the last element as pivot
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low ; j <= high - 1; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high); //swap pivot back, pivot is at the right position
        return i + 1; //
    }
    
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }
    
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] nums = { 10, 7, 8, 9, 1, 5 };
        quickSort(nums, 0, nums.length - 1);
        printArray(nums);
    }
}
