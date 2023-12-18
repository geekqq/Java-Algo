package Day328;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public static List<String> generateParentheses(int n) {
        if (n <= 0) return null;
        List<String> res = new ArrayList<>();
        backTracking(res, "", 0, 0, n);
        return res;
    }

    private static void backTracking(List<String> res, String curStr, int left, int right, int max) {
        if (curStr.length() == 2 * max) {
            res.add(curStr);
            return;
        }
        if (left < max) backTracking(res, curStr + "(", left + 1, right, max);
        if (right < left) backTracking(res, curStr + ")", left, right + 1, max);
    }

    public static void main(String[] args) {
        System.out.println(generateParentheses(3));
    }
}
