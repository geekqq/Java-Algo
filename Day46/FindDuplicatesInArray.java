package Day46;

public class FindDuplicatesInArray {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,3,23,4,};
        findDuplicates(nums);
    }

    public static void findDuplicates(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    count++;
                }
            }
            if (count == 1) {
                System.out.println("the duplicate element is: " + nums[i]);
            }
            count = 0;
        }
    }
}
