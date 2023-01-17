package Day137;

public class HIndex {
    public static void main(String[] args) {
        int[] citations = {1,2,3,4,5,6,8,9,11};
        System.out.println(findHIndex(citations));
    }

    private static int findHIndex(int[] nums) {
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
