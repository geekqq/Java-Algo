package Day34;

public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = {1,2,3,3,3,4,5,6,7,8,9,};
        int target = 1;
        System.out.println(binarySearchS1(nums, target));
        System.out.println(binarySearchS3(nums, target));
    }

    public static int binarySearchS1(int[] nums, int target) {
        //Corner case
        if (nums == null || nums.length == 0) return -1;

        int left = 0;
        int right = nums.length - 1;
        int mid = 0;

        while (left <= right) {
            mid = left + (right - left) / 2; //to avoid int a + b integer overflow
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return mid;
    }

    public static int binarySearchS3(int[] nums, int target) {
        //Corner case
        if (nums == null || nums.length == 0) return -1;

        int left = 0;
        int right = nums.length - 1;
        int mid = 0;

        while (left + 1 < right) {
            mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        //post processing
        if (nums[left] == target) return left;
        if (nums[right] == target) return right;
        return -1;
    }
}
