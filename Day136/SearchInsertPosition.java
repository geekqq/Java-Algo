package Day136;

public class SearchInsertPosition {
    public static void main(String[] args) {
        int[] nums = {1,2,4,5,6,7,8};
        int target = 0;
        System.out.println(findInsertPos(nums, target));
    }
    private static int findInsertPos(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

}
