package Day38;

import java.util.ArrayList;
import java.util.List;

public class FindDuplicatesElementInArray {
    public static void main(String[] args) {
        int[] nums = {3,2,4,5,5,2,2};
        findDuplicateElements(nums);
        System.out.println(findDuplicates(nums));
    }

    public static void findDuplicateElements(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    count++;
                }
            }
            if (count == 1) {
                System.out.println("The duplicate element is: " + nums[i]);
            }
            count = 0;
        }
    }

    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int num = Math.abs(nums[i]);
            if(nums[num - 1] > 0) {
                nums[num - 1] *= -1;
            } else {
                list.add(num);
            }
        }
        return list;
    }

}
