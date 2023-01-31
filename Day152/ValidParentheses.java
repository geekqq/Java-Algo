package Day152;

import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        System.out.println(validParentheses("[]{()"));
    }

    public static final Map<Character, Character> MAP = Map.of(
            '(', ')',
            '[', ']',
            '{', '}'
    );

    private static boolean validParentheses(String s) {
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
