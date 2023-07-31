package Day263;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.Collections;

import static Day256.PrintArray.printArray;
import static Day256.RandomArray.randomArray;
import static Day37.SortedArray.swap;

public class Find2ndMax {

    public static int find2ndMax(int[] nums) {
        if (nums == null || nums.length <= 1) return -1;
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

    public static int find2ndMaxI(int[] nums) {
        //cc
        Integer[] numsInteger = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numsInteger[i] = nums[i];
        }
        Arrays.sort(numsInteger, Collections.reverseOrder());
        return numsInteger[1];
    }

    public static void reverseArray(int[] nums) {
        if (nums == null || nums.length  <= 1) return;
        for (int i = 0; i < nums.length / 2; i++) {
            swap(nums, i, nums.length - 1 - i);
        }
    }

    public static int[] reverseArrayI(int[] nums) {
        if (nums == null || nums.length <= 1) return nums;
        int[] newArr = new int[nums.length];
        int index = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            newArr[index++] = nums[i];
        }
        return newArr;
    }

    public static void main(String[] args) {
        int[] nums = randomArray(10000, 20);
        printArray(nums);
        System.out.println(find2ndMax(nums));
        System.out.println(find2ndMaxI(nums));
        System.out.println("===============================");
        Instant startSwap = Instant.now();
        reverseArray(nums);
        printArray(nums);
        Instant endSwap = Instant.now();
        System.out.println("Swap reverse: " + Duration.between(startSwap, endSwap).getNano());
        System.out.println("===============================");
        Instant startIt = Instant.now();
        int[] newArr = reverseArrayI(nums);
        printArray(newArr);
        Instant endIt = Instant.now();
        System.out.println("Iterate reverse: " + Duration.between(startIt, endIt).getNano());
    }
}
