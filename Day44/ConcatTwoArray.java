package Day44;

import java.util.Arrays;

public class ConcatTwoArray {
    public static void main(String[] args) {
        int[] nums1 = {1,3,5,7};
        int[] nums2 = {2,4,6,8};
        System.out.println(Arrays.toString(concatTwoArray(nums1, nums2)));
    }

    public static int[] concatTwoArray(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int[] newArr = new int[n + m];
        int k = 0;
        for (int i = 0; i < nums1.length; i++) {
            newArr[k++] = nums1[i];
        }
        for (int i = 0; i < nums2.length; i++) {
            newArr[k++] = nums2[i];
        }
        return newArr;
    }
}
