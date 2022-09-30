package Day16;

public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
        int target = 16;
        System.out.println(binarySearch(nums, target, 0, nums.length - 1));
    }

    public static int binarySearch(int[] nums, int target, int left, int right) {
        int mid = left + (right - left) / 2;
        if (left > right) {
            return -1;
        }
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] < target) {
            return binarySearch(nums, target, mid + 1, right);
        } else {
            return binarySearch(nums, target, left, mid - 1);
        }
    }


}
