package Day133;

import java.util.ArrayList;
import java.util.List;

public class FindKClosestElements {
    public static void main(String[] args) {
        int[] nums = {1,2,2,3,3,3,3,4,4,5};
        int k = 4;
        int x = 1;
        System.out.println(findKClosestElements(nums, k, x));
    }

    public static List<Integer> findKClosestElements(int[] nums, int k, int x) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0 || k <= 0) {
            return res;
        }
        k = Math.min(k, nums.length);
        int pos = findClosestIndex(nums, x);
        res.add(nums[pos]);
        addRemaining(res, nums, pos, k - 1, x);
        return res;
    }
    private static int findClosestIndex(int[] nums, int x) {
        int left = 0;
        int right = nums.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == x) {
                return mid;
            } else if (nums[mid] < x) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return Math.abs(nums[left] - x) <= Math.abs(nums[right] - x) ? left : right;
    }
    private static void addRemaining(List<Integer> res, int[] nums, int pos, int count, int x) {
        if (count == 0) return;
        int left = pos - 1;
        int right = pos + 1;
        while (left >= 0 && right < nums.length) {
            if (count == 0) return;
            if (Math.abs(nums[left] - x) <= Math.abs(nums[right] - x)) {
                res.add(0, nums[left--]);
            } else {
                res.add(nums[right++]);
            }
            count--;
        }
        while (count > 0) {
            if (left < 0) {
                res.add(nums[right++]);
            } else {
                res.add(0, nums[left--]);
            }
            count--;
        }
    }
}
