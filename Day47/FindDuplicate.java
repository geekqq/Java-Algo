package Day47;

public class FindDuplicate {
    public static void main(String[] args) {
        int[] nums = {1,0,3,4,3,23,5,1};
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
                System.out.println("重复的元素是：" + nums[i]);
            }
            count = 0;
        }
    }
}
