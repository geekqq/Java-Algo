package Day93;

public class FindDuplicate {
    public static void main(String[] args) {
        int[] nums = {3,3,2,5,6,3,7,8,7};
        findDuplicate(nums);
    }
    public static void findDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        for (int i = 0; i < nums.length - 1; i++) {
            int count = 0;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    count ++;
                }
            }
            if (count == 1) {
                System.out.println("The duplicate element is:" + nums[i]);
            }
            count = 0;
        }
    }
}
