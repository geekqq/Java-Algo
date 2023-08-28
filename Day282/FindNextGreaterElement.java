package Day282;

import java.util.Arrays;
import java.util.Stack;

public class FindNextGreaterElement {

    public static int[] nextGreaterElementArray(int[] arr) {
        if (arr == null || arr.length == 0) return null;
        int[] res = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
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
        int[] arr = {4, 3, 2, 5, 7, 6, 1};
        System.out.println(Arrays.toString(nextGreaterElementArray(arr)));
    }
}
