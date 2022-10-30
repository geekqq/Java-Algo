package Day59;

import java.util.Arrays;

public class MergeSort {
    public static void merge(int[] nums, int l, int m, int r) {
        int leftLen = m - l + 1;
        int rightLen = r - m;

        int[] leftArr = new int[leftLen];
        int[] rightArr = new int[rightLen];

        for (int i = 0; i < leftLen; i++) {
            leftArr[i] = nums[i + l];
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
        while (j <rightLen) {
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

    public static void main(String[] args) {
        int[] nums0 = {-3};
        sort(nums0, 0, nums0.length - 1);
        System.out.println(Arrays.toString(nums0));
        int[] nums1 = {9,12,0,23,-6,-6,-7,-45,55};
        sort(nums1, 0, nums1.length - 1);
        System.out.println(Arrays.toString(nums1));
    }
}
