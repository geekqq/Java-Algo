package Day214;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static Day152.ValidParentheses.MAP;

public class GenerateParentheses {
    public static List<String> generateParentheses(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0) return res;
        getRes(n, n, new StringBuilder(), res);
        return res;
    }

    private static void getRes(int left, int right, StringBuilder sb, List<String> res) {
        if (left == 0 && right == 0) {
            res.add(sb.toString());
            return;
        }
        if (left > right) return;
        if (left > 0) {
            sb.append('(');
            getRes(left - 1, right, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (right > 0 && right > left) {
            sb.append(')');
            getRes(left, right - 1, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static boolean isValidParentheses(String s) {
        if (s == null || s.length() == 0) return false;
        Stack<Character> stack = new Stack<>();
        for (Character c : s.toCharArray()) {
            if (MAP.containsKey(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
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
        System.out.println(generateParentheses(3));
        System.out.println(generateParentheses(5));
        List<String> res1 = generateParentheses(3);
        List<String> res2= generateParentheses(5);
        for (String s : res1) {
            System.out.println(isValidParentheses(s));
        }
        for (String s : res2) {
            System.out.println(isValidParentheses(s));
        }
    }
}
