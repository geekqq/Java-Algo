package Day319;

import java.util.Stack;

import static Day256.PrintArray.printArray;
import static Day256.RandomArray.randomArray;

public class NextGreaterElementArray {

    public static int[] nextGreater(int[] arr) {
        if (arr == null || arr.length == 0) return null;
        int[] res = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }
            res[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(arr[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = randomArray(10, 20);
        printArray(arr);
        int[] res = nextGreater(arr);
        printArray(res);
    }
}
