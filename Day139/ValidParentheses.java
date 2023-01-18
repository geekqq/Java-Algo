package Day139;

import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        System.out.println(isValidParentheses("([]{}())"));

    }

    private static boolean isValidParentheses(String s) {
        if (s == null || s.length() == 0) return false;
        Map<Character, Character> map = Map.of(
                '(', ')',
                '[',']',
                '{','}'
        );
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();

        for (char c : chars){
            if (map.containsKey(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                else {
                    char open = stack.pop();
                    if (map.get(open) == c) {
                        return true;
                    }
                }
            }
        }
        return stack.isEmpty();
    }
}
