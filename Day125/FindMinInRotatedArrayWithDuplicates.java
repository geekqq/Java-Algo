package Day125;
//LeetCode 154
public class FindMinInRotatedArrayWithDuplicates {

    public static void main(String[] args) {
        int[] nums = {6,6,7,7,8,3,4,5,5,6};
        System.out.println(findMinElementInRotatedArrayWithDuplicates(nums));
    }

    public static int findMinElementInRotatedArrayWithDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        if (nums[left] < nums[right]) return nums[left];
        //if (nums.length == 1) return nums[0];

        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[left] == nums[mid]) {
                left++;
            } else if (nums[right] == nums[mid]) {
                right--;
            } else if (nums[mid] > nums[left]) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return Math.min(nums[left], nums[right]);
    }
}
