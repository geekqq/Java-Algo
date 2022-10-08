package Day37;

public class MergeSortTwo {
    public static void merge(int[] leftArr, int[] rightArr, int[] arr, int leftLen, int rightLen) {
        int i = 0;
        int l = 0;
        int r = 0;

        //the while loops check the condition for merging
        while (l < leftLen && r < rightLen) {
            if (leftArr[l] < rightArr[r]) {
                arr[i++] = leftArr[l++];
            } else {
                arr[i++] = rightArr[r++];
            }
        }
        while (l < leftLen) {
            arr[i++] = leftArr[l++];
        }
        while (r < rightLen) {
            arr[i++] = rightArr[r++];
        }
    }

    public static void mergeSort(int[] arr, int len) {
        if (len < 2) return;

        int mid = len / 2;
        int[] leftArr = new int[mid];
        int[] rightArr = new int[len - mid];

        int k = 0;

        for (int i = 0; i < len; i++) {
            if (i < mid) {
                leftArr[i] = arr[i];
            } else {
                rightArr[k++] = arr[i];
            }
        }
        mergeSort(leftArr, mid);
        mergeSort(rightArr, len - mid);

        merge(leftArr, rightArr, arr, mid, len-mid);
    }

    public static void printArray(int[] nums) {
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] nums = {12,1,10,50,5,15,45};
        mergeSort(nums, nums.length);
        printArray(nums);
        System.out.println("test1");
    }
}
