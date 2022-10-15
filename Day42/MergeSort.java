package Day42;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] nums = {1,4,3,0,-5,8,4,7};
        MergeSort ob = new MergeSort();
        ob.mergeSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums)); //not working
    }

    public static void mergeSort(int[] nums, int left, int right) {
        while (left == right) {
            return;
        }
        int mid = left + ((right - left) >> 1);
        mergeSort(nums, left, mid);
        mergeSort(nums,mid + 1, right);
        mergeTwoSortedArray(nums, left, right, mid);
    }

    public static int[] mergeTwoSortedArray(int[] nums, int left, int right, int mid) {
        int[] ans = new int[right - left + 1]; //创建答案数组
        int i = left; //左边数组的起始下标
        int j = mid + 1;  //右边数组的起始下标
        int k = 0; //答案数组的index

        while (i <= mid && j <= right) {
            ans[k++] = nums[i] <= nums[j] ? nums[i++] : nums[j++];
        }

        while (i < mid) {
            ans[k++] = nums[i++];
        };
        while (j < right) {
            ans[k++] = nums[j++];
        }
        return ans;
    }
}
