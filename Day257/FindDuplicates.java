package Day257;

public class FindDuplicates {
    public static void findDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return;
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
            count =0;
        }
    }
}
