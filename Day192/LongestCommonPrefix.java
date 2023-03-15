package Day192;

public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] words = {"leek", "leetcode", "leeg"};
        System.out.println(getLCP(words));
    }

    public static String getLCP(String[] words) {
        if (words == null || words.length == 0) return null;
        String prefix = words[0];
        for (int i = 1; i < words.length; i++) {
            while (words[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.length() == 0) {
                    return null;
                }
            }
        }
        return prefix;
    }
}
