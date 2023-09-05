package Day286;

public class MedianInTwoSortedArray {

    public static double findMedianTwoSortedArray(int[] nums1, int[] nums2) {
        if (nums1 == null && nums2 == null) throw new IllegalArgumentException("invalid input!");
        int l1 = nums1.length;
        int l2 = nums2.length;
        int len = l1 + l2;
        if (len % 2 == 0) {
            int i1 = findKthSmallest(nums1, nums2, len / 2);
            int i2 = findKthSmallest(nums1, nums2, len / 2 + 1);
            return (i1 + i2) / 2.0;
        } else {
            return findKthSmallest(nums1, nums2, len / 2 + 1);
        }
    }
    //k is 1 based;
    private static int findKthSmallest(int[] arr1, int[] arr2, int k) {
        int l1 = arr1.length;
        int l2 = arr2.length;
        if (k < 1 || (l1 + l2) < k) throw new IllegalArgumentException("invalid input!");
        return dfs(arr1, 0, l1 - 1, arr2, 0, l2 - 1, k);
    }

    private static int dfs(int[] arr1, int start1, int end1, int[] arr2, int start2, int end2, int k) {
        int l1 = end1 - start1 + 1;
        int l2 = end2 - start2 + 1;
        if (l1 > l2) {
            return dfs(arr2, start2, end2, arr1, start1, end1, k);
        }
        if (start1 > end1) {
            return arr2[start2 + k - 1]; //arr1 is exhausted, simply return arr2[start2 + k - 1], again k is 1 based, so -1 to 0 base
        }
        if (k == 1) {
            return Math.min(arr1[start1], arr2[start2]);
        }

        int partition1 = Math.min(k / 2, l1);
        int partition2 = k - partition1;
        int mid1 = start1 + partition1 - 1;
        int mid2 = start2 + partition2 - 1;
        if (arr1[mid1] < arr2[mid2]) {
            return dfs(arr1, mid1 + 1, end1, arr2, start2, end2, k - partition1);
        } else {
            return dfs(arr1, start1, end1, arr2, mid2 + 1, end2, k - partition2);
        }
    }

    public static void main(String[] args) {
        int[] num1 = {1, 3, 6};
        int[] num2 = {2, 3};
        System.out.println(findMedianTwoSortedArray(num1, num2));
    }
}
