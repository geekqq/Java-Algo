package Day168;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = {"leetcode", "leek", "leese"};
        System.out.println(getLCP(strs));
    }

    private static String getLCP(String[] strs) {
        if (strs == null || strs.length == 0) return null;
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return null;
                }
            }
        }
        return prefix;
    }
}
