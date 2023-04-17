package Day214;

import java.util.ArrayList;
import java.util.List;

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

    public static void main(String[] args) {
        System.out.println(generateParentheses(3));
        System.out.println(generateParentheses(5));
    }
}
