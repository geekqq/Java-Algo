package Day146;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = {"leetcode", "leets", "leeds", "leekcity"};
        System.out.println(lcp(strs));
    }

    private static String lcp(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0,prefix.length() - 1);
                if (prefix.length() == 0) return "";
            }
        }
        return prefix;
    }
}
