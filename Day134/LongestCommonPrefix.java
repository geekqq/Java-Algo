package Day134;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = {"leets", "leetcode", "leet", "leeds"};
        System.out.println(findLongestCommonPrefix(strs));
    }

    private static String findLongestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        return prefix;
    }
}
