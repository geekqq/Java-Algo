package Day260;

import static Day256.PrintArray.printArray;
import static Day256.RandomArray.randomArray;

public class FindSecondMax {
    public static int findSecondMax(int[] nums) {
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                secondMax = max;
                max = nums[i];
            } else if (nums[i] > secondMax && nums[i] != max) {
                secondMax = nums[i];
            }
        }
        return secondMax;
    }

    public static void merge(int[] nums, int l, int m, int r) {
        int leftLen = m - l + 1;
        int rightLen = r - m;
        int[] leftArr = new int[leftLen];
        int[] rightArr = new int[rightLen];
        for (int i = 0; i < leftLen; i++) {
            leftArr[i] = nums[i];
        }
        for (int i = 0; i < rightLen; i++) {
            rightArr[i] = nums[m + 1 + i];
        }
        int i = 0;
        int j = 0;
        int k = l;
        while (i < leftLen && j < rightLen) {
            if (leftArr[i] < rightArr[j]) {
                nums[k++] = leftArr[i++];
            } else {
                nums[k++] = rightArr[j++];
            }
        }
        while (i < leftLen) {
            nums[k++] = leftArr[i++];
        }
        while (j < rightLen) {
            nums[k++] = rightArr[j++];
        }
    }

    public static void sort(int[] nums, int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;
            sort(nums, l, m);
            sort(nums, m + 1, r);
            merge(nums, l, m, r);
        }
    }

    public static void main(String[] args) {
        int[] nums = randomArray(10, 16);
        printArray(nums);
        System.out.println(findSecondMax(nums));
        sort(nums, 0, nums.length - 1);
        printArray(nums);

    }
}
