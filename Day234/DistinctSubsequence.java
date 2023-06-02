package Day234;

public class DistinctSubsequence {
    //LC115
    public static int numDistinct(String s, String t) {
        if (s == null && t == null) return 0;

        int[][] res = new int[t.length() + 1][s.length() + 1];

        for (int i = 0; i < s.length(); i++) {
            res[0][i] = 1;
        }

        for (int i = 0; i < t.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                if (t.charAt(i) == s.charAt(j)) {
                    res[i + 1][j + 1] = res[i + 1][j] + res[i][j];
                } else {
                    res[i + 1][j + 1] = res[i + 1][j];
                }
            }
        }
        return res[t.length()][s.length()];
    }
}
