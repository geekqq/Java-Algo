package Day289;

import java.util.Stack;

public class ValidParentheses {

    public static boolean validParentheses(String s) {
        if (s == null || s.length() == 0) return false;
        Stack<Character> stack = new Stack<>();
        for (Character c : s.toCharArray()) {
            if (c == '[' || c == '{' || c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                else {
                    char top = stack.peek();
                    if (top == '[' && c == ']'
                    || top == '(' && c == ')'
                    || top == '{' && c == '}') {
                        stack.pop();
                    }
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(validParentheses("[]{})"));
    }
}
