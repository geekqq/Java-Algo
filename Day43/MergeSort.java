package Day43;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] nums = {1,4,3,0,-5,8,4,7};
    }

    //S1 helper array
    //carry on the helper array with the same size, space O(n)
    public int[] mergeSort1(int[] array) {
        //corner case
        if (array == null || array.length <= 1) {
            return array;
        }

        int[] helper = new int[array.length];
        //method overloading
        mergeSort1(array, helper, 0, array.length - 1);
        return array;
    }

    private void mergeSort1(int[] array, int[] helper, int left, int right) {
        //recursion base case
        if (left == right) return;
        int mid = left + (right - left) / 2;
        mergeSort1(array, helper, left, mid);
        mergeSort1(array, helper, mid + 1, right);
        merge1(array, helper, left, mid, right);
    }

    private void merge1(int[] array, int[] helper, int left, int mid, int right) {
        //copy the data to the helper array
        for (int i = left; i <= right ; i++) {
            helper[i] = array[i];
        }

        int leftI = left;
        int rightI = mid + 1;

        while (leftI < mid && rightI < right) {
            if (helper[leftI] < helper[rightI]) {
                array[left++] = helper[leftI++];
            } else {
                array[left++] = helper[rightI++];
            }
        }

        while (leftI < left) {
            array[left++] = helper[leftI++];
        }
        while (rightI < right) {
            array[left++] = helper[rightI++];
        }
    }
}
