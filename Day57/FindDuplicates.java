package Day57;

public class FindDuplicates {
    public static void main(String[] args) {
        int[] nums = {-1,5,3,7,3,26,0,5,0,0,0,0};
        findDuplicate(nums);
    }

    public static void findDuplicate(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    count++;
                }
            }
            if (count == 1) {
                System.out.println("The duplicate element is: " + nums[i]);
            }
            count = 0;
        }
    }
}
