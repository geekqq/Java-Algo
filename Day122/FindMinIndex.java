package Day122;

public class FindMinIndex {
    //find min index in a rorated array
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,8,2};
        System.out.println(findMinIndex(nums));
    }
    public static int findMinIndex(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
