package Day312;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    public static List<String> generateParentheses(int n) {
        if (n <= 0) return null;
        List<String> res = new ArrayList<>();
        backTracking(res, "", 0, 0, n);
        return res;
    }

    private static void backTracking(List<String> res, String cur, int open, int close, int max) {
        if (cur.length() == max * 2) {
            res.add(cur);
            return;
        }
        if (open < max) backTracking(res, cur + "(", open + 1, close, max);
        if (close < open) backTracking(res, cur + ")", open, close + 1, max);
    }

    public static void main(String[] args) {
        System.out.println(generateParentheses(3));
    }
}
