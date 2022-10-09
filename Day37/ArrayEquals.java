package Day37;

import java.util.Arrays;

public class ArrayEquals {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        int[] arr1 = {1,2,3,4,5,6};
        int[] arr2 = {1,2,3,4};
        int[] arr3 = new int[] {1,2,3,4};
        System.out.println("数组arr是否与数组arr1相等？ " + Arrays.equals(arr, arr1));
        System.out.println("数组arr是否与数组arr2相等？ " + Arrays.equals(arr, arr2));
        System.out.println("数组arr2是否与数组arr3相等？ " + Arrays.equals(arr2, arr3));
    }
}
