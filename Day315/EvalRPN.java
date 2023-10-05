package Day315;

import java.util.Stack;

public class EvalRPN {

    public static int evalRPN(String[] tokens) {
        //cc
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (token.equals("+")) {stack.push(stack.pop() + stack.pop());}
            else if (token.equals("*")) {stack.push(stack.pop() * stack.pop());}
            else if (token.equals("-")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b - a);
            }
            else if (token.equals("/")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b / a);
            } else {
                stack.push(Integer.valueOf(token));
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
