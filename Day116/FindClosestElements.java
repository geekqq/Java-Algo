package Day116;

import java.util.ArrayList;
import java.util.List;

public class FindClosestElements {
    public static List<Integer> findClosestElements(int[] nums, int k, int x) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0 || k <= 0) {
            return res;
        }
        k = Math.min(k, nums.length);
        int pos = findClosest(nums, x);
        res.add(nums[pos]);
        addRemaining(res, nums, pos, k - 1, x);
        return res;
    }
    private static int findClosest(int[] nums, int x) {
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
        return Math.abs(nums[left] - x) < Math.abs(nums[right] - x) ? left : right;
    }
    private static void addRemaining(List<Integer> res, int[] nums, int pos, int count, int x) {
        if (count == 0) return;
        int left = pos - 1;
        int right = pos + 1;
        while (left >= 0 && right < nums.length) {
            if (count == 0) {
                return;
            }
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
                res.add(0, nums[left--]); //把结果加在list的前面index为0的位置
            }
            count--;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,3,4,4,4,5,5,5,5,6,6,6,7,9,9};
        int k = 4;
        int x = 19;
        System.out.println(findClosestElements(nums, k, x));
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        for (int i = 0; i < 10; i++) {
            list.add(0,i);
        }
        System.out.println(list);
    }
}
