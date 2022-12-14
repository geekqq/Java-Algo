package Day103;

public class FindDuplicate {
    public static void main(String[] args) {
        int[] nums = {20,20,40,30,10,30,50,40};
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
                System.out.println("the duplicate element is: " + nums[i]);
            }
            count = 0;
        }
    }
}
