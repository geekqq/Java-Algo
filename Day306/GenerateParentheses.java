package Day306;

import java.util.LinkedList;
import java.util.List;

public class GenerateParentheses {

    public static List<String> generateParentheses(int n) {
        List<String> res = new LinkedList<>();
        dfs(n, 0, 0, res, new StringBuilder());
        return res;
    }

    private static void dfs(int n, int left, int right, List<String> res, StringBuilder sb) {
        if (left == n && right == n) {
            res.add(sb.toString());
            return;
        }
        if (right > left || left > n) return;
        sb.append("(");
        dfs(n, left + 1, right, res, sb);
        sb.deleteCharAt(sb.length() - 1);

        sb.append(")");
        dfs(n, left, right + 1, res, sb);
        sb.deleteCharAt(sb.length() - 1);
    }

    public static void main(String[] args) {
        System.out.println(generateParentheses(3));
    }
}
