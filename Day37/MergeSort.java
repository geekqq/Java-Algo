package Day37;

public class MergeSort {
    //Merge two subarrays of arr[]
    //first is arr[l...m]
    //second is arr[m+1...r]

    public void merge(int[] arr, int l, int m, int r) {
        //find sizes of two subarrays to be merged
        int nl = m - l + 1;
        int nr = r - m;

        //create temp arrays
        int[] leftArr = new int[nl];
        int[] rightArr = new int[nr];

        //copy data to the temp arrays
        for (int i = 0; i < nl; i++) {
            leftArr[i] = arr[l + i];
        }
        for (int j = 0; j < nr; j++) {
            rightArr[j] = arr[m + 1 + j];
        }

        //merge the temp arrays
        int i = 0;
        int j = 0;
        int k = l;
        while (i < nl && j < nr) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }

        // copy remaining elements of leftArr if any left
        while (i < nl) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }

        //copy remaining elements of rightArr if any left
        while (j < nr) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }

    //main function that sorts arr[l...r] using merge()

    public void sort(int arr[], int l, int r) {
        if (l < r) {
            //find the middle index
            int m = l + (r - l) / 2;
            sort(arr, l, m);
            sort(arr, m + 1, r);
            //merge the two sorted halves
            merge(arr, l, m, r);
        }
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {12,11,18,2,5,8,7,0};
        System.out.println("the original array is:");
        printArray(arr);
        MergeSort ob = new MergeSort();
        ob.sort(arr, 0, arr.length - 1);
        System.out.println("the new sorted array is:");
        printArray(arr);
    }
}
