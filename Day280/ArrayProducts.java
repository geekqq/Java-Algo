package Day280;

import java.util.Arrays;

public class ArrayProducts {

    public static void arrayProducts(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException();
        }

        int product = 1;
        for (int i = 0; i < arr.length; i++) {
            product *= arr[i];
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = product / arr[i];
        }
    }

    public static int[] findProduct(int[] arr) {
        // two for loops
        int[] res = new int[arr.length];
        int temp = 1;
        //first loop to store product before the element
        for (int i = 0; i < arr.length; i++) {
            res[i] = temp;
            temp *= arr[i];
        }

        //second loop to get the product after the element
        temp = 1;
        for (int i = arr.length - 1; i >= 0; i--) {
            res[i] = res[i] * temp;
            temp *= arr[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1,2 ,3, 4};
        arrayProducts(arr);
        System.out.println(Arrays.toString(arr));
        int[] arr1 = {3,5,4,8,7};
        System.out.println(Arrays.toString(findProduct(arr1)));
    }
}
