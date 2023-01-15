package Day135;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = {-1, 2, 1, 0, -4, -1};
        System.out.println(threeSum(nums));
    }

    private static List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        //sort + two pointers
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int temp = nums[left] + nums[right];
                if (temp + nums[i] == 0) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    //去重
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                } else if (temp + nums[i] < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return res;
    }
}
