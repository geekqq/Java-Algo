package Day315;

public class FindKthSmallest {

    public static int findKthSmallest(int[] arr1, int[] arr2, int k) {
        //cc
        int i = 0;
        int j = 0;
        int kIdx = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                kIdx++;
                if (kIdx == k)  return arr1[i];
                i++;
            } else {
                kIdx++;
                if (kIdx == k) return arr2[j];
                j++;
            }
        }
        while (i < arr1.length) {
            kIdx++;
            if (k == kIdx) return arr1[i];
            i++;
        }
        while (j < arr2.length) {
            kIdx++;
            if (k == kIdx) return arr2[j];
            j++;
        }
        return -1;
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
