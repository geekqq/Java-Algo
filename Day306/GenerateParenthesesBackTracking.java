package Day306;

import java.util.LinkedList;
import java.util.List;

public class GenerateParenthesesBackTracking {

    public static List<String> generateParentheses(int n) {
        List<String> res = new LinkedList<>();
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
