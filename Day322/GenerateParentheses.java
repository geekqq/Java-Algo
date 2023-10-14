package Day322;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    public static List<String> generateParentheses(int n) {
        if (n <= 0) return null;
        List<String> res = new ArrayList<>();
        backTrack(res, "", 0, 0, n);
        return res;
    }

    private static void backTrack(List<String> res, String cur, int open, int close, int max) {
        if (cur.length() == max * 2 ) {
            res.add(cur);
            return;
        }
        if (open < max) backTrack(res, cur + "(", open + 1, close, max);
        if (close < open) backTrack(res, cur + ")", open, close + 1, max);
    }

    public static void main(String[] args) {
        System.out.println(generateParentheses(3));
    }
}
