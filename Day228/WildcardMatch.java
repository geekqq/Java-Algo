package Day228;

public class WildcardMatch {
    public static boolean isMatch(String s, String p) {
        if (s == null && p == null) return true;
        if (s == null || p == null) return false;
        return isMatch(s, p, 0, 0) == 2;
    }

    private static int isMatch(String s, String p, int i, int j) {
        if (i == s.length() && j == p.length()) return 2;
        if (i == s.length() && p.charAt(j) != '*') return 0;
        if (j == p.length()) return 1;

        if (p.charAt(j) == '*') {
            if (i + 1 < p.length() && p.charAt(j + 1) == '*') {
                return isMatch(s, p, i, j + 1);
            }

            for (int k = 0; k < s.length() - i; k++) {
                int res = isMatch(s, p, i + k, j + 1);
                if (res == 0 || res == 2) return res;
            }
        }
        if (p.charAt(j) == '?' || (p.charAt(j) == s.charAt(i))) {
            return isMatch(s, p, i + 1, j + 1);
        }
        return 1;
    }
}
