package Day256;

import java.util.Arrays;

import static Day256.RandomArray.randomArray;

public class SearchTargetInRotatedArray {

    public static boolean search(int[] nums, int t) {
        int R = nums.length - 1;
        while (R > 0 && nums[R] == nums[0]) R--;
        if (R == 0) return nums[0] == t;

        int l = 0;
        int r = R;
        while (l < r) {
            int m = l + r + 1 >> 1;
            if (nums[m] >= nums[0]) l = m;
            else {
                r = m - 1;
            }
        }
        if (t >= nums[0]) {
            l = 0;
        } else {
            l = r + 1;
            r = R;
        }
        while (l < r) {
            int m = l + r >> 1;
            if (nums[m] < t) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return nums[r] == t;
    }

    public static void main(String[] args) {
        int[] nums = randomArray(10, 15);
        System.out.println(Arrays.toString(nums));
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        int[] arr = {7, 8, 8, 10, 0, 2, 2, 5, 6, 6};
        for (int i = -2; i < 15; i++) {
            System.out.println(i + " = " + search(nums, i));
        }
    }

}
