package Day52;

public class MergeSort {
    void merge(int[] arr, int l, int mid, int r) {
        //size of the two subArray
        int leftLen = mid - l + 1;
        int rightLen = r - mid;

        int[] leftArr = new int[leftLen];
        int[] rightArr = new int[rightLen];

        for (int i = 0; i < leftLen; i++) {
            leftArr[i] = arr[i + l];
        }
        for (int j = 0; j < rightLen; j++) {
            rightArr[j] = arr[mid + 1 + j];
        }

        int i = 0;
        int j = 0;
        int k = l;

        while (i < leftLen && j < rightLen) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
            }
        }
        while (i < leftLen) {
            arr[k++] = leftArr[i++];
        }
        while (j < rightLen) {
            arr[k++] = rightArr[j++];
        }
    }

    void sort(int[] arr, int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;
            sort(arr, l, m);
            sort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }
    public static void printArray(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] nums = {12, -11, 13, 5, 16, 7, 0 , 7, 7};
        MergeSort ob = new MergeSort();
        ob.sort(nums, 0, nums.length - 1);
        printArray(nums);
    }
}
