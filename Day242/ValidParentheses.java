package Day242;

import java.util.Stack;

public class ValidParentheses {

    public static boolean validParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        for (Character c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (!stack.isEmpty() && isMatchedPair(stack.peek(), c)) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
    private static boolean isMatchedPair(char left, char right) {
        return (left == '[' && right == ']') || (left == '{' && right == '}') || (left == '(' && right == ')');
    }

    public static void main(String[] args) {
        System.out.println(validParentheses("[][])"));
    }
}
