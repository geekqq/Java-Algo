package Day59;

public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8,9,10};
        int t = 10;
        System.out.println(binarySearch(nums, t));
        System.out.println(0 % 3);
    }
    public static int binarySearch(int[] nums, int t) {
        if (nums == null || nums.length == 0) return -1;

        int left = 0;
        int right = nums.length - 1;
        int m = 0;

        while (left <= right) {
            m = left + (right - left) / 2;
            if (nums[m] == t) {
                return m;
            } else if (nums[m] < t) {
                left = m + 1;
            } else {
                right = m - 1;
            }
        }
        return -1;
    }
}
