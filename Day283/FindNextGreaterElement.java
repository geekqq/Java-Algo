package Day283;

import java.util.Stack;

import static Day256.PrintArray.printArray;
import static Day256.RandomArray.randomArray;

public class FindNextGreaterElement {

    public static int[] nextGreaterElementArray(int[] arr) {
        if (arr == null || arr.length == 0) return null;
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            if (!stack.isEmpty()) {
                while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                    stack.pop();
                }
            }
            if (stack.isEmpty()) {
                res[i] = - 1;
            } else {
                res[i] = stack.peek();
            }
            stack.push(arr[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = randomArray(10, 150);
        printArray(arr);
        int[] res = nextGreaterElementArray(arr);
        printArray(res);
    }
}
