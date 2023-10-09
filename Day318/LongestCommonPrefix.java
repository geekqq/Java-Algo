package Day318;

public class LongestCommonPrefix {

    public static String getLCP(String[] words) {
        if (words == null || words.length == 0) return null;
        String prefix = words[0];
        for (int i = 1; i < words.length; i++) {
            while (words[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }
        return prefix.isEmpty() ? "null" : prefix;
    }

    public static void main(String[] args) {
        String[] strs = {"leet", "leetcode", "lee"};
        System.out.println(getLCP(strs));
    }
}
