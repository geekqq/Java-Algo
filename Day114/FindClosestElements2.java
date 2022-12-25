package Day114;

public class FindClosestElements2 {
    public static int findCrossOver(int[] nums, int low, int high, int x) {
        if (nums[high] <= x) {
            return high;
        }
        if (nums[low] > x) {
            return low;
        }
        int mid = low + (high - low) / 2;
        if (nums[mid] <= x && nums[mid + 1] > x) {
            return mid;
        }
        if (nums[mid] > x) {
            return findCrossOver(nums, mid + 1, high, x);
        }
        return findCrossOver(nums, low, mid - 1, x);
    }

    public static void printKClosest(int[] nums, int x, int k, int n) {
        //n is the length of the given array
        int l = findCrossOver(nums, 0, n - 1, x);
        int r = l + 1;
        int count = 0; // to keep track of count of elements already printed
        //If x is present in the array, reduce left index , here we assume no duplicated elements.
        if (nums[l] == x) {
            l--;
        }
        while (l >= 0 && r < n && count < k) {
            if (x - nums[l] < nums[r] - x) {
                System.out.print(nums[l--] + " ");
            } else {
                System.out.print(nums[r++] + " ");
            }
            count++;
        }
        while (count < k && l >= 0) {
            System.out.print(nums[l--] + " ");
            count++;
        }
        while (count < k && r < n) {
            System.out.print(nums[r++] + " ");
            count++;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8};
        int k = 4;
        int x = 1;
        int n = nums.length;
        printKClosest(nums, x, k, n);
    }
}
