package Day45;

public class FindDuplicate {
    public static void main(String[] args) {
        int[] nums = {1,0,3,5,2,4,3,5,2,2,0};
        findDuplicateElement(nums);
    }

    public static void findDuplicateElement(int[] nums) {
        if (nums == null || nums.length == 0) return;
        for (int i = 0; i < nums.length - 1; i++) {
            int count = 0;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    count++;
                }
            }
            if (count == 1) {
                System.out.println("重复的元素为：" + nums[i]);
            }
            count = 0;
        }
    }
}
