package Day60;

public class FindDuplicates {
    public static void main(String[] args) {
        int[] nums = {1,-10,2,3,4,3,3,5,7,2,9,9,0,-10};
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
                System.out.println("重复的元素是：" + nums[i]);
            }
            count = 0;
        }
    }
}
