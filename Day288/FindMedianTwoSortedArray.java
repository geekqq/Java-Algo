package Day288;

public class FindMedianTwoSortedArray {

    public static double findMedianTwoSortedArray(int[] nums1, int[] nums2) {
        if (nums1 == null && nums2.length == 0) throw new IllegalArgumentException("Invalid input");
        int l1= nums1.length;
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

    private static int findKthSmallest(int[] nums1, int[] nums2, int k) {
        int l1 = nums1.length;
        int l2 = nums2.length;
        if (k <= 0 || (l1 + l2) < k) {
            throw new IllegalArgumentException("Invalid input!");
        }
        return dfs(nums1, 0, l1 - 1, nums2, 0, l2 - 1, k);
    }

    private static int dfs(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
        int l1 = nums1.length;
        int l2 = nums2.length;
        if (l1 > l2) {
            return dfs(nums2, start2, end2, nums1, start1, end1, k);
        }
        if (start1 > end1) {
            return nums2[start2 + k - 1];
        }
        if (k == 1) {
            return Math.min(nums1[start1], nums2[start2]);
        }
        int partition1 = Math.min(k / 2, l1);
        int partition2 = k - partition1;
        int mid1 = start1 + partition1 - 1;
        int mid2 = start2 + partition2 - 1;
        if (nums1[mid1] < nums2[mid2]) {
            return dfs(nums1, mid1 + 1, end1, nums2, start2, end2, k - partition1);
        } else {
            return dfs(nums1, start1, end1, nums2, mid2 + 1, end2, k - partition2);        }
    }

    public static void main(String[] args) {
        int[] num1 = {1, 3, 6};
        int[] num2 = {2, 3, 5};
        System.out.println(findMedianTwoSortedArray(num1, num2));
    }
}
