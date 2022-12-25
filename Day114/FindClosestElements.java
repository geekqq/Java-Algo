package Day114;

import java.util.ArrayList;
import java.util.List;
//find the closest k elements to x in a sorted array
//if a tie, prefer the smaller elements
//input [1,2,3,4,5], k = 4, x = 3
//output [1,2,3,4]

public class FindClosestElements {
    public static List<Integer> findClosestElements(int[] nums, int k, int x) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        List<Integer> res = new ArrayList<>();
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        while (left + 1 < right) {
            mid = left + (right = left) / 2;
            if (nums[mid] < x) {
                left = mid;
            } else {
                right = mid;
            }
        }
        for (int i = 0; i < k; i++) {
            if (left >= 0 && right <= nums.length - 1) {
                if (Math.abs(nums[left] - x) <= Math.abs(nums[right] - x)) {
                    left--;
                } else {
                    right++;
                }
            } else if (left < 0) {
                right++;
            } else {
                left--;
            }
        }
        int start = left < 0 ? 0 : left + 1;

        for (int i = 0; i < k; i++) {
            res.add(nums[start + i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        int k = 3;
        int x = 10;
        System.out.println(findClosestElements(nums, k, x));
    }
}
//似乎不是正确答案
