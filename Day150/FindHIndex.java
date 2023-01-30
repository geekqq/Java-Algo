package Day150;

public class FindHIndex {
    public static void main(String[] args) {
        int[] citations = {2,4,6,8,9,12};
        System.out.println(findHIndex(citations));
    }

    private static int findHIndex(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) {
            return nums[0] == 0 ? 0 : 1;
        }
        int left = 0;
        int n = nums.length;
        int right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == n - mid) {
                return n - mid;
            } else if (nums[mid] < n - mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return n - left;
    }
}
