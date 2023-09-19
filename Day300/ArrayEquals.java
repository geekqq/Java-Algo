package Day300;

import java.util.Arrays;
import java.util.Collections;

public class ArrayEquals {

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3};
        int[] arr2 = {1, 2, 3};
        int[] arr3 = {1, 2, 3, 0};
        System.out.println(arr1.equals(arr2));
        System.out.println(arr1 == arr2);
        System.out.println(Arrays.equals(arr1, arr2));
        System.out.println(Arrays.equals(arr1, arr3));
    }
}
