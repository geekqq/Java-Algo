package Day40;

public class FindDuplicates {
    public static void main(String[] args) {
        int[] nums = {1,2,3,2,0,-1,-1,4};
        findDuplicateElementInArray(nums);
    }

    public static void findDuplicateElementInArray(int[] nums) {
        if (nums == null || nums.length == 0) return;

        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    count++;
                }
            }
            if (count == 1) {
                System.out.println("重复的元素是： " + nums[i]);
            }
            count = 0;
        }
    }
}
