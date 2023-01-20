package Day140;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static Day138.RandomArray.randomArray;

public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = randomArray(10, 10);
        System.out.println(Arrays.toString(nums));
        int[] nums2 = {-1, 2, 1, 0, -4, -1, 4};
        System.out.println(threeSum(nums2));
    }

    private static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int temp = nums[left] + nums[right];
                if (nums[i] + temp == 0) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                } else if (nums[i] + temp < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return res;
    }
}
