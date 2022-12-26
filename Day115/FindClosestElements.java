package Day115;

import java.util.ArrayList;
import java.util.List;

public class FindClosestElements {
    public static List<Integer> findClosestElements(int[] nums, int k, int x) {
        List<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0 || k <= 0) {
            return result;
        }
        k = Math.min(nums.length, k);
        int pos = findClosest(nums, x);
        result.add(nums[pos]);
        addRemaining(result, nums, pos, k - 1, x);
        return result;
    }

    //find the closest element
    private static int findClosest(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid;
            } else {
                left = mid;
            }        }
        return Math.abs(nums[left] - target) <= Math.abs(nums[right] - target) ? left : right;
    }

    private static void addRemaining(List<Integer> result, int[] nums, int pos, int count, int target) {
        if (count == 0) return;
        int left = pos - 1;
        int right = pos + 1;
        while (left >= 0 && right <= nums.length - 1) {
            if (count == 0) break;
            if (Math.abs(nums[left] - target) <= Math.abs(nums[right] - target)) {
                result.add(0, nums[left--]);
            } else {
                result.add(nums[right++]);
            }
            count--;
        }
        while (count > 0) {
            if (left < 0) {
                result.add(nums[right++]);
            } else {
                result.add(nums[left--]);
            }
            count--;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        int k = 4;
        int x = -1;
        System.out.println(findClosestElements(nums, k, x));
    }
}
