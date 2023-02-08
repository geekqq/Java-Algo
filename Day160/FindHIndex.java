package Day160;

public class FindHIndex {
    public static void main(String[] args) {
        int[] citations = {1,2,3,4,6,8,9,12};
        System.out.println(findHIndex(citations));
    }

    private static int findHIndex(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException();
        }
        int left = 0;
        int n = nums.length;
        int right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == n - mid) return n - mid;
            else if (nums[mid] < n - mid) left = mid + 1;
            else right = mid - 1;
        }
        return n - left;
    }
}
