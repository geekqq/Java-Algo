package Day37;

import java.util.Arrays;

public class DeleteElementInArray {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,67,10};
        System.out.println(Arrays.toString(deleteInArray(nums, 1)));
    }

    public static int[] deleteInArray(int[] array, int n) {
        // delete element of index n from the array
        if (n < 0 || n >= array.length) {
            throw new RuntimeException("元素下标越界。。。");
        }
        int[] newArr = new int[array.length - 1];
        for (int i = 0; i < newArr.length; i++) {
            if (i < n) {
                newArr[i] = array[i];
            } else {
                newArr[i] = array[i + 1];
            }
        }
        return newArr;
    }
}
