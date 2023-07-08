package Day256;

import java.util.Arrays;
import java.util.Random;

import static Day37.SortedArray.swap;

public class RandomArray {

    public static int[] randomArray(int size, int max) {
        int[] arr = new int[size];
        Random rd = new Random();
        for (int i = 0; i < size; i++) {
            int num = rd.nextInt(max + 1); //generate random num from 0 to max;
            arr[i] = num;
        }
        return arr;
    }

    public static void main(String[] args) {
        //int[] num = randomArray(10, 15);
        System.out.println(Arrays.toString(randomArray(10, 15)));
        System.out.println(Arrays.toString(randomArray(10, 15)));
        System.out.println(Arrays.toString(randomArray(10, 15)));
        System.out.println(Arrays.toString(randomArray(10, 15)));
        System.out.println(Arrays.toString(randomArray(10, 15)));
        System.out.println(Arrays.toString(randomArray(10, 15)));
        System.out.println(Arrays.toString(randomArray(10, 15)));
        System.out.println(Arrays.toString(randomArray(10, 15)));

        System.out.println("+++++++++++++++++++++++++++++++++++++");
        System.out.println(Arrays.toString(generateRandomArrayWithNoDuplicates(10, 10, 20)));
        System.out.println(Arrays.toString(generateRandomArrayWithNoDuplicates(10, 10, 20)));
        System.out.println(Arrays.toString(generateRandomArrayWithNoDuplicates(10, 10, 20)));
        System.out.println(Arrays.toString(generateRandomArrayWithNoDuplicates(10, 10, 20)));
        System.out.println(Arrays.toString(generateRandomArrayWithNoDuplicates(10, 10, 20)));
        System.out.println(Arrays.toString(generateRandomArrayWithNoDuplicates(10, 10, 20)));
        System.out.println(Arrays.toString(generateRandomArrayWithNoDuplicates(10, 10, 20)));
        System.out.println("+++++++++++++++++++++++++++++++++++++");
        int[] nums = generateRandomArrayWithNoDuplicates(6, 5,15);
        System.out.println(Arrays.toString(nums));
        selectSort(nums);
        System.out.println(Arrays.toString(nums));
        System.out.println("+++++++++++++++++++++++++++++++++++++");
        int[] nums1 = generateRandomArrayWithNoDuplicates(6, 5,15);
        System.out.println(Arrays.toString(nums1));
        insertSort(nums1);
        System.out.println(Arrays.toString(nums1));
        System.out.println("+++++++++++++++++++++++++++++++++++++");
        int[] nums2 = generateRandomArrayWithNoDuplicates(6, 3, 15);
        System.out.println(Arrays.toString(nums2));
        bubbleSort(nums2);
        System.out.println(Arrays.toString(nums2));
    }

    public static int[] generateRandomArrayWithNoDuplicates(int size, int min, int max) {
        if (max - min + 1 < size) {
            throw new IllegalArgumentException();
        }

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
    public static void selectSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[min] > nums[j]) {
                    min = j;
                }
            }
            swap(nums, i, min);
        }
    }

    public static void insertSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int key = nums[i];
            int j = i - 1;
            while (j >= 0 && nums[j] > key) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = key;
        }
    }

    public static void bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            boolean flag = true;
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                    flag = false;
                }
            }
            if (false) break;
        }
    }
}
