package Day58;

public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = {2,6,12,25,78,99,120,246,247};
        int t = 249;
        System.out.println(binarySearch(nums, t));
    }

    public static int binarySearch(int[] nums, int t) {
        if (nums == null || nums.length == 0) return  -1;
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
