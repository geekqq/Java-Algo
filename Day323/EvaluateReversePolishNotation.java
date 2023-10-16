package Day323;

import java.util.Stack;

public class EvaluateReversePolishNotation {

    public static int evalRPN(String[] tokens) {
        //cc
        Stack<Integer> stack = new Stack<>();
        for (String t : tokens) {
            if (t.equals("+")) stack.push(stack.pop() + stack.pop());
            else if (t.equals("*")) stack.push(stack.pop() * stack.pop());
            else if (t.equals("-")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b - a);
            } else if (t.equals("/")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b / a);
            } else {
                stack.push(Integer.valueOf(t));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String[] tokens = {"2","1","+","3","*"};
        String[] tokens1 = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(evalRPN(tokens));
        System.out.println(evalRPN(tokens1));
    }
}
