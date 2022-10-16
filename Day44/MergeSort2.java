package Day44;

import Day42.MergeSort;

public class MergeSort2 {
    public static void main(String[] args) {
        int[] nums = {12,11,13,6,5,7};
        MergeSort2 ob = new MergeSort2();
        ob.sort(nums, 0, nums.length - 1);
        printArray(nums);
    }
    void merge(int[] arr, int l, int r, int m) {
        //find the sizes of the subarrays
        int nl = m - l + 1;
        int nr = r - m;

        //create a temp array
        int[] arrl = new int[nl];
        int[] arrr= new int[nr];

        //copy data to temp array
        for (int i = 0; i < nl; i++) {
            arrl[i] = arr[l + i];
        }
        for (int i = 0; i < nr; i++) {
            arrr[i] = arr[m + 1 + i];
        }

        //initial indexes of the first and second subarrays
        int i = 0;
        int j = 0;
        int k = l;

        while (i < nl && j < nr) {
            if (arrl[i] <= arrr[j]) {
                arr[k++] = arrl[i++];
            } else {
                arr[k++] = arrr[j++];
            }
        }
        while (i < nl) {
            arr[k++] = arrl[i++];
        }
        while (r < nr) {
            arr[k++] = arrr[j++];
        }
    }

    //sort arr[l...r] using merge()
    void sort(int[] arr, int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;
            sort(arr, l, m);
            sort(arr, m + 1, r);
            merge(arr, l, r, m);
        }
    }

    static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
