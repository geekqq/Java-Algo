package Day328;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperature {

    public static int[] nextWarmerDay(int[] temp) {
        if (temp == null || temp.length == 0) return null;
        int[] res = new int[temp.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = temp.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && temp[stack.peek()] <= temp[i]) {
                stack.pop();
            }
            res[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] temperatures = {73,74,75,71,69,72,76,73};
        System.out.println(Arrays.toString(nextWarmerDay(temperatures)));
    }
}
