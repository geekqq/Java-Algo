package Day145;

import java.util.Map;
import java.util.Stack;

public class IsValidParentheses {
    public static void main(String[] args) {
        System.out.println(isValidParentheses("[][()"));
    }
    private static final Map<Character, Character> MAP = Map.of(
            '(', ')',
            '[', ']',
            '{', '}'
    );

    private static boolean isValidParentheses(String s) {
        if (s == null || s.length() == 0) return false;
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
