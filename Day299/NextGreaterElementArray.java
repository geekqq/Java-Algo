package Day299;


import java.util.Stack;

import static Day256.PrintArray.printArray;
import static Day256.RandomArray.randomArray;

public class NextGreaterElementArray {

    public static int[] nextGreaterElement(int[] arr) {
        int[] res = new int[arr.length];
        if (arr == null || arr.length == 0) return res;
        Stack<Integer> stack = new Stack();
        for (int i = arr.length - 1; i >= 0; i--) {
            if (!stack.isEmpty()) {
                while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                    stack.pop();
                }
            }
            if (stack.isEmpty()) {
                res[i] = -1;
            } else {
                res[i] = stack.peek();
            }

            stack.push(arr[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = randomArray(10, 20);
        printArray(arr);
        int[] res = nextGreaterElement(arr);
        printArray(res);
    }
}
