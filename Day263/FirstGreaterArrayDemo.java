package Day263;


import java.util.Stack;

import static Day256.PrintArray.printArray;
import static Day256.RandomArray.randomArray;

public class FirstGreaterArrayDemo {

    public static int[] firstGreaterArray(int[] nums) {
        //cc
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException();
        }

        int[] result = new int[nums.length];
        Stack<Integer> stack = new Stack();
        for (int i = nums.length - 1; i >= 0; i--) {
            if (!stack.isEmpty()) {
                while (!stack.isEmpty() && stack.peek() <= nums[i]) {
                    stack.pop();
                }
            }
            if (stack.isEmpty()) {
                result[i] = -1;
            } else {
                result[i] = stack.peek();
            }
            stack.push(nums[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = randomArray(10, 15);
        printArray(nums);
        int[] newArr = firstGreaterArray(nums);
        printArray(newArr);
    }
}
