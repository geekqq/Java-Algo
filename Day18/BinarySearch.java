package Day18;

public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8,9,10};
        int[] nums2 = {9};
        int target = 10;
        int target2 = 9;
        System.out.println(binarySearch(nums, target));
        System.out.println(binarySearch(nums2, target2));
    }

    public static int binarySearch(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;

        //Binary Search
        int left = 0, right = nums.length - 1, mid = 0;

        while (left <= right) {
            mid = left + (right - left) / 2;

            if(nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return mid;
    }
}
