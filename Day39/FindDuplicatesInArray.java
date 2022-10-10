package Day39;

public class FindDuplicatesInArray {
    public static void main(String[] args) {
        int[] nums = {4,6,2,-1,0,2,5,2,2};
        findDuplicates(nums);
    }

    public static void findDuplicates(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
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
