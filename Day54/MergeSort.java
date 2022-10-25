package Day54;

public class MergeSort {
    public static void merge(int[] nums, int l, int m, int r) {
        int leftLen = l - m + 1;
        int rightLen = r - m;

        int[] leftArr = new int[leftLen];
        int[] rightArr = new int[rightLen];

        for (int i = 0; i < leftLen; i++) {
            leftArr[i] = nums[l + i];
        }
        for (int i = 0; i < rightLen; i++) {
            rightArr[i] = nums[m + 1 + i];
        }
        int i = 0;
        int j = 0;
        int k = l;
        while (l < leftLen && r < rightLen) {
            if (leftArr[i] < rightArr[j]) {
                nums[k++] = leftArr[i++];
            } else {
                nums[k++] = rightArr[j++];
            }
        }
        while (l < leftLen) {
            nums[k++] = leftArr[i++];
        }
        while (r < rightLen) {
            nums[k++] = rightArr[j++];
        }
    }

    public static void mergeSort(int[] nums, int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;
            mergeSort(nums, l, m);
            mergeSort(nums, m + 1, r);
            merge(nums, l, m, r);
        }
    }

}
