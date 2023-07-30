package Day263;

import java.util.Stack;

import static Day152.ValidParentheses.MAP;

public class IsValidParentheses {

    public static boolean isValid(String s) {
        if (s == null || s.length() == 0) return false;
        Stack<Character> stack = new Stack<>();
        for (Character c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    Character open = stack.peek();
                    if ((open == '(' && c == ')')
                        || (open == '[' && c == ']')
                            || (open == '{' && c == '}')
                    ) {
                        stack.pop();
                    }
                }
            }
        }
        return stack.isEmpty();
    }

    public static boolean isValidUsingMap(String s) {

        if (s == null || s.length() == 0) return false;
        Stack<Character> stack = new Stack<>();
        for (Character c : s.toCharArray()) {
            if (MAP.containsKey(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                else {
                    Character open = stack.pop();
                    if (MAP.get(open) != c) {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("[]{}("));
        System.out.println(isValidUsingMap("[]{}()"));

    }
}
