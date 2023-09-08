package Day290;

public class FindKthSmallest {

    public static int findKthSmallestTwoSortedArray(int[] arr1, int[] arr2, int k) {
        int l1 = arr1.length;
        int l2 = arr2.length;
        if (k <= 0 || (l1 + l2) < k) throw new IllegalArgumentException("invalid input");
        int kIdx = 0;
        int i = 0;
        int j = 0;
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
        return -1;
    }

    public static void main(String[] args) {
        int[] arr1 = {3, 5, 7, 10};
        int[] arr2 = {1, 4, 9, 11};
        System.out.println(findKthSmallestTwoSortedArray(arr1, arr2, 5));
    }
}
