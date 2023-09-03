package Day286;

public class FindMedianTwoSortedArray {

    public static double findMedianTwoSortedArray(int[] arr1, int[] arr2) {
        //cc

        if (arr1 == null && arr2 == null) throw new IllegalArgumentException("Invalid input");

        int l1 = arr1.length;
        int l2 = arr2.length;
        if (arr1 == null) {
            if (l2 % 2 == 0) {
                return (arr2[l2 / 2 - 1] + arr2[l2/ 2]) / 2.0;
            } else {
                return arr2[l2 / 2];
            }
        }

        if (arr2 == null) {
            if (l1 % 2 == 0) {
                return (arr1[l1 / 2 - 1] + arr1[l1 / 2]) / 2.0;
            } else {
                return arr1[l1 / 2];
            }
        }

        int len = l1 + l2;
        if (len % 2 == 0) {
            int num1 = findKthSmallest(arr1, arr2, len / 2 + 1);
            int num2 = findKthSmallest(arr1, arr2, len / 2);
            return  (num1 + num2) / 2.0;
        } else {
            return (double) findKthSmallest(arr1, arr2, len / 2 + 1);
        }
    }

    private static int findKthSmallest(int[] arr1, int[] arr2, int k) {
        int i = 0;
        int j = 0;
        int kIdx = 0;
        while (i < arr1.length && j < arr2.length) {
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

        while (i < arr1.length) {
            kIdx++;
            if (kIdx == k) return arr1[i];
            i++;
        }
        while (j < arr2.length) {
            kIdx++;
            if (kIdx == k) return arr2[j];
            j++;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] num1 = {1, 3, 6};
        int[] num2 = {2, 3, 5};
        System.out.println(findMedianTwoSortedArray(num1, num2));
    }
}
