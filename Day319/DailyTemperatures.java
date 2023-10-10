package Day319;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures {

    public static int[] nextWarmerDay(int[] temperature) {
        //cc
        int[] res = new int[temperature.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = temperature.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && temperature[stack.peek()] <= temperature[i]) {
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
