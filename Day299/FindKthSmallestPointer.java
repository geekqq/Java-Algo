package Day299;

public class FindKthSmallestPointer {

    public static int findKthSmallest(int[] arr1, int[] arr2, int k) {
        int l1 = arr1.length;
        int l2 = arr2.length;
        int i = 0;
        int j = 0;
        int kIdx = 0;
        while (i < l1 && j < l2) {
            if (arr1[i] < arr2[j]) {
                kIdx++;
                if (kIdx == k) return arr1[i];
                i++;
            } else {
                kIdx++;
                if (kIdx == k) return arr2[j];
                j++;
            }
        }
        while (i < l1) {
            kIdx++;
            if (kIdx == k) return arr1[i];
            i++;
        }
        while (j < l2) {
            kIdx++;
            if (kIdx == k) return arr2[j];
            j++;
        }
        return Integer.MAX_VALUE;
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
