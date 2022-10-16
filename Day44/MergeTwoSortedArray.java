package Day44;

import java.util.Arrays;

public class MergeTwoSortedArray {
    public static void main(String[] args) {
        int[] nums1 = {1,3,5,7};
        int[] nums2 = {2,4,6,8};
        System.out.println(Arrays.toString(mergeTwo(nums1, nums2)));
    }

    public static int[] mergeTwo(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int[] ans = new int[n + m];
        int l = 0;
        int r = 0;
        int k = 0;

        while (l < n && r < m) {
            if (nums1[l] <= nums2[r]) {
                ans[k++] = nums1[l++];
            } else {
                ans[k++] = nums2[r++];
            }
        }
        while (l < n) {
            ans[k++] = nums1[l++];
        }
        while (r < m) {
            ans[k++] = nums2[r++];
        }
        return ans;
    }
}
