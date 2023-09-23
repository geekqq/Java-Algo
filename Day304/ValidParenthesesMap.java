package Day304;

import java.util.Map;
import java.util.Stack;

public class ValidParenthesesMap {
    private static final Map<Character, Character> MAP = Map.of(
            '(', ')',
            '[', ']',
            '{', '}'
            );

    public static boolean validParenthesesMap(String s) {
        if (s == null || s.length() == 0) return false;
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (MAP.containsKey(c)) {
                stack.push(c);
            } else {
                if (s.isEmpty()) {
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

    public static void main(String[] args) {
        System.out.println(validParenthesesMap("{(}"));
        System.out.println(validParenthesesMap("{()}"));
    }
}
