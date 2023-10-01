package Day312;

public class FindKthSmallest {

    public static int findKthSmallest(int[] arr1, int[] arr2, int k) {
        int l1 = arr1.length;
        int l2 = arr2.length;
        if (k <= 0 || (l1 + l2) < k) throw new IllegalArgumentException();
        return dfs(arr1, 0, l1 - 1, arr2, 0, l2 - 1, k);
    }

    private static int dfs(int[] arr1, int start1, int end1, int[] arr2, int start2, int end2, int k) {
        int l1 = end1 - start1 + 1;
        int l2 = end2 - start2 + 1;
        if (l1 > l2) return dfs(arr2, start2, end2,arr1, start1, end1, k);
        if (start1 > end1) return arr2[start2 + k - 1];
        if (k == 1) return Math.min(arr1[start1], arr2[start2]);
        int partition1 = Math.min(l1, k / 2);
        int partition2 = k - partition1;
        int mid1 = start1 + partition1 - 1;
        int mid2 = start2 + partition2 - 1;
        if (arr1[mid1] < arr2[mid2]) return dfs(arr1, mid1 + 1, end1, arr2, start2, end2, k - partition1);
        else return dfs(arr1, start1, end1, arr2, mid2 + 1, end2, k - partition2);
    }

    public static void main(String[] args) {
        int[] nums1 = {2,4,5,7,9};
        int[] nums2 = {1,3,4,5};
        System.out.println(findKthSmallest(nums1, nums2, 3));
        System.out.println(findKthSmallest(nums1, nums2, 5));
        System.out.println(findKthSmallest(nums1, nums2, 6));
        System.out.println(findKthSmallest(nums1, nums2, 7));
    }
}
