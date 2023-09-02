package Day285;

public class FindKthSmallestElementInTwoSortedArray {

    public static int findKthElementTwoSortedArray(int[] arr1, int[] arr2, int k) {
        if (arr1 == null) return arr2[k - 1];
        if (arr2 == null) return arr1[k - 1];
        int kIdx = 0;
        int i = 0;
        int j = 0;
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
        int arr1[] = {2, 3, 6, 7, 9};
        int arr2[] = {1, 4, 8, 10};
        int[] arr3 = {100, 112, 256, 349, 770};
        int[] arr4 = {72, 86, 113, 119, 265, 445, 892};

        System.out.println(findKthElementTwoSortedArray(arr1, arr2, 7));
        System.out.println(findKthElementTwoSortedArray(arr3, arr4, 7));
    }

}
