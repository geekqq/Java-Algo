package Day37;

import java.util.HashSet;
import java.util.Set;

public class FindDuplicateInArray {
    public static void main(String[] args) {
        int[] nums = {1,2,4,5,5,6,7,6,2,9,2,2,5,5,2,2};
        findDuplicateInArray(nums);
        System.out.println("------");
        findDuplicateInArrayUsingSet(nums);
    }

    public static void findDuplicateInArray(int[] array) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j]) {
                    count++;
                }
            }
            if (count == 1) {
                System.out.println("重复元素是：" + array[i]);
            }
            count = 0;
        }
    }

    public static void findDuplicateInArrayUsingSet(int[] array) {
        //create a set
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < array.length; i++) {
            if (!set.add(array[i])) {
                System.out.println("重复元素是：" + array[i]);
            }
        }
    }
}
