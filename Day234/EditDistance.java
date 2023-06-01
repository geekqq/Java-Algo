package Day234;

public class EditDistance {

    public static int minDistance(String word1, String word2) {
        if (word1 == null && word2 == null) return 0;
        if (word1 == null || word2 == null) return word1 == null ? word2.length() : word1.length();

        int m = word1.length();
        int n = word2.length();

        int[][] res = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            res[i][0] = i;
        }
        for (int i = 0; i <= n; i++) {
            res[0][i] = i;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    res[i + 1][j + 1] = res[i][j];
                } else {
                    res[i + 1][j + 1] = Math.min(Math.min(res[i][j + 1], res[i + 1][j]), res[i][j]) + 1;
                }
            }
        }
        return res[m][n];
    }
}
