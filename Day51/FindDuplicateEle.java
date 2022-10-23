package Day51;

import java.util.HashSet;
import java.util.Set;

public class FindDuplicateEle {
    public static void main(String[] args) {
        int[] nums = {30,20,20,40,10,30,50,30};
        findDuplicate(nums);
        findDupUsingSet(nums);
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

    public static void findDupUsingSet(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i])) {
                System.out.println("the duplicate element is: " + nums[i]);
            }
        }
    }
}
