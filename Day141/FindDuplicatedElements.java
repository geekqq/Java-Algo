package Day141;

public class FindDuplicatedElements {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,4,5,5,6,6,6,6};
        findDuplicates(nums);
    }
    private static void findDuplicates(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            int count = 0;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    count++;
                }
            }
            if (count == 1) {
                System.out.println("The duplicates element is: " + nums[i]);
                count = 0;
            }
        }
    }
}
