package Day149;

import java.util.Map;
import java.util.Stack;

public class IsValidParentheses {
    public static void main(String[] args) {
        System.out.println(validParentheses("[][]()}"));
    }

    public static final Map<Character, Character> MAPPARENTHESES = Map.of(
            '(', ')',
            '[', ']',
            '{', '}'
    );

    private static boolean validParentheses(String s) {
        if (s == null || s.length() == 0) {
            throw new IllegalArgumentException();
        }
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (MAPPARENTHESES.containsKey(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    char open = stack.pop();
                    if (MAPPARENTHESES.get(open)!= c) {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }
}
