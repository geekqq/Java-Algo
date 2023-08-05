package Day266;

import java.util.Arrays;
import java.util.Random;

import static Day256.PrintArray.printArray;
import static Day37.SortedArray.swap;

public class RecursionDemo {

    public static void printNum(int num) {
        if (num == 0) return;
        System.out.println(num);
        printNum(num - 1);
    }



    public static int catEyes(int cats) {
        if (cats == 0) return 0;
        return catEyes(cats - 1) + 2;
    }


    public static void main(String[] args) {
        printNum(15);
        System.out.println(catEyes(4));
        System.out.println(power(3, 4));
        System.out.println("---factorial---");
        System.out.println(factorial(5));
        System.out.println("---fibonacci numbers---");
        System.out.println(fibonacci(5));
        for (int i = 0; i < 15; i++) {
            System.out.print(fibonacci(i) + " ");
        }
        System.out.println("---mobile phone speakers---");
        System.out.println(speakers(4));

        System.out.println("---digit sum---");
        System.out.println(digitSum(1234));

        System.out.println("---count five---");
        System.out.println(countFive(1523525));

        System.out.println("--binary search using recursion---");
        int[] nums = generateArray(10, 5, 20);
        printArray(nums);
        insertSort(nums);
        printArray(nums);
        System.out.println(binarySearch(nums, 14, 0, nums.length - 1));
    }

    public static int power(int base, int num) {
        if (num == 1) return base;
        else return base * power(base, num - 1);
    }

    public static int factorial(int num) {
        if (num == 1 || num == 0) return 1;
        return factorial(num - 1) * num;
    }

    public static int fibonacci(int num) {
        if (num == 0) return 0;
        if (num == 1) return 1;
        return fibonacci(num - 1) + fibonacci(num - 2);
    }

    public static int speakers(int mobiles) {
        if (mobiles == 0) return 0;
        else {
            if ((mobiles & 1) == 0) {
                return 2 + speakers(mobiles - 1);
            } else {
                return 1 + speakers(mobiles - 1);
            }
        }
    }

    public static int digitSum(int num) {
        if (num == 0 || num == 1) return num;
        return digitSum(num / 10) + num % 10;
    }

    public static int countFive(int num) {
        if (num == 0) return 0;
        if (num == 5) return 1;
        if (num % 10 == 5) {
            return 1 + countFive(num / 10);
        } else {
            return countFive(num / 10);
        }
    }

    public static int binarySearch(int[] nums, int key, int start, int end) {
        if (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] < key) {
                return binarySearch(nums, key, mid + 1, end);
            } else if (key < nums[mid]) {
                return binarySearch(nums, key, start, mid - 1);
            } else {
                return mid;
            }
        } else {
            return -1;
        }
    }

    public static int[] generateArray(int size, int min, int max) {
        if (max - min + 1 < size) {
            throw new IllegalArgumentException();
        }
        int[] arr = new int[size];
        boolean[] used = new boolean[max - min + 1];
        Arrays.fill(used, true);
        Random rd = new Random();
        int index = 0;
        while (index < size) {
            int num = rd.nextInt(max - min + 1) + min;
            if (used[num - min]) {
                arr[index++] = num;
                used[num - min] = false;
            }
        }
        return arr;
    }

    public static void bubbleSort(int[] nums) {
        if (nums == null || nums.length == 0) return;
        for (int i = 0; i < nums.length - 1; i++) {
            boolean flag = true;
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                    flag = false;
                }
            }
            if (flag) break;
        }
    }

    public static void selectSort(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int min;
        for (int i = 0; i < nums.length - 1; i++) {
            min = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[min]) {
                    min = j;
                }
            }
            swap(nums, i, min);
        }
    }

    public static void insertSort(int[] nums) {
        if (nums == null || nums.length == 0) return;
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
}
