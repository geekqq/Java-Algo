package Day91;

public class FindDuplicate {
    public static void findDuplicate(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            int count = 0;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    count ++;
                }
            }
            if (count == 1) {
                System.out.println("重复的元素是：" + nums[i]);
            }
            count = 0;
        }
    }

    public static void main(String[] args) {
        int[] nums = {3,3,2,5,6,3,7,8,7};
        findDuplicate(nums);
    }
}
