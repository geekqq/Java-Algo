package Day309;


import java.util.Arrays;
import java.util.Stack;

public class DailyTemperature {

    public static int[] nextWarmerDay(int[] temperatures) {
        if (temperatures == null || temperatures.length == 0) return null;
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[temperatures.length];
        for (int i = temperatures.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]) {
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
