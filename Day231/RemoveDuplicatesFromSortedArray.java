package Day231;

public class RemoveDuplicatesFromSortedArray {

    //LC80
    public static int removeDuplicates(int[] nums) {
        if (nums == null) return -1;
        if (nums.length <= 2) return nums.length;

        //This can be implemented to n(n >= 1)

        int slow = 2;
        for (int fast = 2; fast < nums.length; fast++) {
            //slow - n...
            if (nums[slow - 2] != nums[fast]) {
                nums[slow++] = nums[fast];
            }
        }
        return slow;
    }
}
