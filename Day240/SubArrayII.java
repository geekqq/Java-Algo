package Day240;

import java.util.ArrayList;
import java.util.List;

public class SubArrayII {
    public static void printSubArrays(int[] arr, int start, int end) {
        if (end == arr.length) return;
        else if (start > end) {
            printSubArrays(arr, 0, end + 1);
        } else {
            System.out.print("[");
            for (int i = start; i < end; i++) {
                System.out.print(arr[i] + ",");
            }
            System.out.println(arr[end] + "]");
            printSubArrays(arr, start + 1, end);
        }
    }

    public static List<List<Integer>> getSubArrays(int[] nums, int start, int end) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        if (end == nums.length) return res;
        else if (start > end) {
            res.addAll(getSubArrays(nums, 0, end + 1));
        } else {
            List<Integer> subArray = new ArrayList<>();
            for (int i = start; i < end; i++) {
                subArray.add(nums[i]);
            }
            subArray.add(nums[end]);
            res.add(subArray);
            res.addAll(getSubArrays(nums, start + 1, end));
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2 ,3, 4};
        printSubArrays(arr, 0, 0);
        System.out.println(getSubArrays(arr, 0, 0));
    }
}
