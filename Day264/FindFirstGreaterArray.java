package Day264;


import java.util.Stack;

import static Day256.PrintArray.printArray;
import static Day256.RandomArray.randomArray;

public class FindFirstGreaterArray {

    public static int[] findFirstGreaterArray(int[] nums) {
        if (nums == null || nums.length == 0) return nums;
        Stack<Integer> stack = new Stack();
        int[] res = new int[nums.length];
        for (int i = nums.length - 1; i >= 0 ; i--) {
            if (!stack.isEmpty()) {
                while (!stack.isEmpty() && stack.peek() <= nums[i]) {
                    stack.pop();
                }
            }
            if (stack.isEmpty()) {
                res[i] = -1;
            } else {
                res[i] = stack.peek();
            }
            stack.push(nums[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = randomArray(10, 15);
        printArray(nums);
        int[] res = findFirstGreaterArray(nums);
        printArray(res);
    }
}
