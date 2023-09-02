package Day285;

public class FindKthSmallestTwoSortedArray {

    public static int findKthSmallestSortedArray(int[] arr1, int[] arr2, int k) {
        int len1 = arr1.length;
        int len2 = arr2.length;
        if (k < 1 || len1 + len2 < k) {
            throw new IllegalArgumentException("Invalid input!");
        }
        return dfs(arr1, 0, len1 - 1, arr2, 0, len2 - 1, k);
    }

    private static int dfs(int[] arr1, int start1, int end1, int[] arr2, int start2, int end2, int k) {
        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;
        if (len1 > len2) {
            return dfs(arr2, start2, end2, arr1, start1, end1, k);
        }

        if (start1 > end1) {
            return arr2[start2 + k - 1];
        }

        if (k == 1) {
            return Math.min(arr1[start1], arr2[start2]);
        }

        int partition1 = Math.min(k / 2, len1);
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
        int[] nums1 = {1,2, 4, 5, 6,9};
        int[] nums2 = {3,7,8,10};
        System.out.println(findKthSmallestSortedArray(nums1, nums2, 5));
    }
}
