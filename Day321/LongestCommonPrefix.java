package Day321;

public class LongestCommonPrefix {

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return null;
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }
        return prefix.isEmpty() ? "null" : prefix;
    }

    public static void main(String[] args) {
        String[] strs = {"sleet", "leetcode", "lee"};
        System.out.println(longestCommonPrefix(strs));
    }
}
