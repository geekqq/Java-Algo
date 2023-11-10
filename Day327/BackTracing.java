package Day327;

import java.util.ArrayList;
import java.util.List;

public class BackTracing {

    public static List<String> generateParentheses(int n) {
        List<String> res = new ArrayList<>();
        backTracing(res, "", 0, 0, n);
        return res;
    }
    private static void backTracing(List<String> res, String cur, int open, int close, int max) {
        if (cur.length() == max * 2) {
            res.add(cur);
            return;
        }
        if (open < max) backTracing(res, cur + "(", open + 1, close, max);
        if (close < open) backTracing(res, cur + ")", open, close + 1, max);
    }

    public static void main(String[] args) {
        System.out.println(generateParentheses(3));
    }
}
