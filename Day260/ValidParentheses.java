package Day260;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {

    public static Map<Character, Character> map = Map.of(
            '(', ')',
            '[', ']',
            '{', '}'
    );
    public static boolean isValidParentheses(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }

        Stack<Character> stack = new Stack<>();
        for (Character c : s.toCharArray()) {
            if (map.containsKey(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                else {
                    Character open = stack.pop();
                    if (map.get(open) != c) {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValidParentheses("[][[]{}"));
    }
}
