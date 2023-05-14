package Day229;

public class LongestPalindromicSubstring {
    public static String longestPalindrome(String s) {
        if (s == null || s.length() <= 1) return s;
        int[] max = new int[1];
        int[] res = new int[2];

        for (int i = 0; i < s.length() - 1; i++) {
            findMax(s, i, i, max, res);
            findMax(s, i, i + 1, max, res);
        }
        return s.substring(res[0], res[1]);
    }

    private static void findMax(String s, int left, int right, int[] max, int[] res) {
        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            } else {
                break;
            }
        }
        int dist = right - left - 1;
        if (dist > max[0]) {
            max[0] = dist;
            res[0] = left + 1;
            res[1] = right;
        }
    }

    public static void main(String[] args) {

        System.out.println(longestPalindrome("babad"));
    }
}
