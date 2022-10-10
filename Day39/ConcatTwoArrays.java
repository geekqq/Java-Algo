package Day39;

import java.util.Arrays;

public class ConcatTwoArrays {
    public static void main(String[] args) {
        String[] arr1 = {"A", "B", "C"};
        String[] arr2 = {"E", "G", "F"};
        System.out.println(Arrays.toString(concatTwoStringArray(arr1, arr2)));
    }

    public static String[] concatTwoStringArray(String[] arr1, String[] arr2) {

        String[] newArr = new String[arr1.length + arr2.length];
        int k = 0; //初始化新的array的index为0
        for (int i = 0; i < arr1.length; i++) {
            newArr[k++] = arr1[i];
        }
        for (int j = 0; j < arr2.length; j++) {
            newArr[k++] =arr2[j];
        }
        return newArr;
    }
}
