package Day61;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] nums = {23, 12, 1, 8, -3, 0, 90};
        sort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    public static void merge(int[] nums, int l, int m, int r) {
        int leftLen = m - l + 1;
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

        while (i < leftLen && j < rightLen) {
            if (leftArr[i] < rightArr[j]) {
                nums[k++] = leftArr[i++];
            } else {
                nums[k++] = rightArr[j++];
            }
        }
        while (i < leftLen) {
            nums[k++] = leftArr[i++];
        }
        while (j < rightLen) {
            nums[k++] = rightArr[j++];
        }
    }

    public static void sort(int[] nums, int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;
            sort(nums, l, m);
            sort(nums, m + 1, r);
            merge(nums, l, m, r);
        }
    }
}
