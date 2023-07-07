package Day254;

import java.util.Arrays;
import java.util.Random;

public class InsertionSort {

    public static void insertSort(int[] nums) {
        if (nums == null || nums.length == 0) return;
        for (int i = 1; i < nums.length; i++) {
            int j = i;
            int toInsert = nums[i];
            while (j > 0 && nums[j - 1] > toInsert) {
                nums[j] = nums[j - 1];
                j--;
            }
            nums[j] = toInsert;
        }
    }

    public static int[] generateRandomArray(int size, int min ,int max) {
        if (max - min + 1 < size) throw new IllegalArgumentException();
        int[] arr = new int[size];
        boolean[] used = new boolean[max - min + 1];
        int index = 0;
        Random rd = new Random();
        while (index < size) {
            int num = rd.nextInt(max - min + 1) + min;
            if (!used[num - min]) {
                arr[index++] = num;
                used[num - min] = true;
            }
        }
        return arr;
    }
    public static void main(String[] args) {
        int[] arr = generateRandomArray(8, 10, 20);
        System.out.println(Arrays.toString(arr));
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
