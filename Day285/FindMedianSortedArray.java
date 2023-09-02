package Day285;

import java.util.Arrays;

public class FindMedianSortedArray {

    public static double findMedianSortedArray(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        if (m > n) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;

            int tmp = m;
            m = n;
            n = tmp;
        }

        int iMin = 0;
        int iMax = m;
        int halfLen = (m + n + 1) / 2;

        while (iMin <= iMin) {
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;

            if (i < m && nums2[j - 1] > nums1[i]) {
                iMin = i + 1;
            } else if (i > 0 && nums1[i - 1] > nums2[j]) {
                iMax = i - 1;
            } else {
                int maxOfLeft;
                if (i == 0) {
                    maxOfLeft = nums2[j - 1];
                } else if (j == 0) {
                    maxOfLeft = nums1[i - 1];
                } else {
                    maxOfLeft = Math.max(nums1[i - 1], nums2[j - 1]);
                }

                if ((m + n) % 2 == 1) {
                    return maxOfLeft;
                }

                int minOfRight;
                if (i == m) {
                    minOfRight = nums2[j];
                } else if (j == n) {
                    minOfRight = nums1[i];
                } else {
                    minOfRight = Math.min(nums1[i], nums2[j]);
                }

                return (maxOfLeft + minOfRight) / 2.0;
            }
        }
        return 0.0;
    }


    public static double findMedianI(int[] num1, int[] num2) {
        int[] num3 = new int[num1.length + num2.length];
        System.arraycopy(num1, 0, num3, 0, num1.length);
        System.arraycopy(num2, 0, num3, num1.length, num2.length);
        Arrays.sort(num3);

        if (num3.length % 2 == 0) {
            return (double) (num3[num3.length / 2] + num3[num3.length / 2 - 1]) / 2;
        } else {
            return num3[num3.length / 2];
        }
    }


    public static void main(String[] args) {
        int[] num1 = {1, 2, 4};
        int[] num2 = {5, 6, 7};
        System.out.println(findMedianSortedArray(num1, num2));
        System.out.println(findMedianI(num1, num2));
    }
}
