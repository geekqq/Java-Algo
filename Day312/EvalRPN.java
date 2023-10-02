package Day312;

import java.util.Stack;

public class EvalRPN {

    public static int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) throw new IllegalArgumentException();
        Stack<Integer> stack = new Stack<>();
        for (String c : tokens) {
            if (c.equals("+")) {
                stack.push(stack.pop() + stack.pop());
            } else if (c.equals("-")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b - a);
            } else if (c.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            } else if (c.equals("/")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b / a);
            } else {
                stack.push(Integer.parseInt(c));
            }
        }
        return stack.peek();
    }

    public static void main(String[] args) {
        String[] tokens = {"2","1","+","3","*"};
        String[] tokens1 = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(evalRPN(tokens));
        System.out.println(evalRPN(tokens1));
    }
}
