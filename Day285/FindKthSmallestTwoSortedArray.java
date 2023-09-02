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

    public static int findKthSmallest(int[] arr1, int[] arr2, int k) {
        if (arr1 == null) return arr2[k - 1];
        if (arr2 == null) return arr1[k - 1];
        int m = arr1.length;
        int n = arr2.length;
        int[] mergedArr = new int[m + n];
        int i = 0;
        int j = 0;
        int p = 0;
        while (i < m && j < n) {
            if (arr1[i] < arr2[j]) {
                mergedArr[p++] = arr1[i++];
            } else {
                mergedArr[p++] = arr2[j++];
            }
        }
        while (i < m) {
            mergedArr[p++] = arr1[i++];
        }
        while (j < n) {
            mergedArr[p++] = arr2[j++];
        }
        return mergedArr[k - 1];
    }

    public static void main(String[] args) {
        int arr1[] = {2, 3, 6, 7, 9};
        int arr2[] = {1, 4, 8, 10};
        int[] arr3 = {100, 112, 256, 349, 770};
        int[] arr4 = {72, 86, 113, 119, 265, 445, 892};
        System.out.println(findKthSmallestSortedArray(arr1, arr2, 7));
        System.out.println(findKthSmallestSortedArray(arr3, arr4, 7));
        System.out.println(findKthSmallest(arr1, arr2, 7));
        System.out.println(findKthSmallest(arr3, arr4, 7));
    }
}
