package Day159;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static Day138.RandomArray.randomArray;

public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = {3,0,-1,4,1,2,0,-4};
        System.out.println(threeSum(nums));
    }

    private static List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException();
        }
        List<List<Integer>> res = new LinkedList<>();
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
                    res.add(Arrays.asList(nums[i], nums[right], nums[left]));
                    left++;
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
