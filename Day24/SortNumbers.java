package Day24;

import java.util.Arrays;

public class SortNumbers {
    public static void main(String[] args) {
        int a = 11;
        int b = 5;
        int c = 9;
        System.out.println(Arrays.toString(sortAndPrint(a, b, c)));
    }

    public static int[] sortAndPrint(int a, int b, int c) {
        int[] nums = {a, b, c};
        for (int i = nums.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[i]) {
                    int temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                }
            }
        }
        return nums;
    }
}
