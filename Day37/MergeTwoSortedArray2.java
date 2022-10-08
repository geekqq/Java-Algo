package Day37;

import java.util.Arrays;

public class MergeTwoSortedArray2 {
    public static void main(String[] args) {
        int[] array1 = {5,7,9,12};
        int[] array2 = {4,6,8,9};
        System.out.println(Arrays.toString(mergeTwo(array1, array2)));
    }

    public static int[] mergeTwo(int[] arr1, int[] arr2) {
        int[] newArr = new int[arr1.length + arr2.length];

        //initial the index of merged array;
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] <= arr2[j]) {
                newArr[k++] = arr1[i++];

            } else {
                newArr[k++] = arr2[j++];
            }
        }
        while (i < arr1.length) {
            newArr[k++] = arr1[i++];
        }

        while (j < arr2.length) {
            newArr[k++] = arr2[j++];
        }
        return newArr;
    }
}
