package Day136;

import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
    private static final Map<Character, Character> map = Map.of(
            '(', ')',
            '[', ']',
            '{', '}');
    public static boolean isValidParentheses(String s) {
        if (s == null || s.length() == 0) return false;
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char open = stack.pop();
                if (map.get(open) != c) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValidParentheses("([]{}"));
    }
}
