package Day171;

import java.util.Stack;

import static Day152.ValidParentheses.MAP;

public class ValidParentheses {
    public static void main(String[] args) {

    }

    private static boolean validParentheses(String s) {
        if (s == null || s.length() == 0) {
            throw new IllegalArgumentException();
        }

        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (MAP.containsKey(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    char open = stack.pop();
                    if (MAP.get(open) != c) {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }
}
