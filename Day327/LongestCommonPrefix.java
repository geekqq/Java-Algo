package Day327;

public class LongestCommonPrefix {

    public static String getLongestCommonPrefix(String[] words) {
        if (words == null || words.length == 0) return null;
        String prefix = words[0];
        for (int i = 1; i < words.length; i++) {
            while (words[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }
        return prefix.length() == 0 ? null : prefix;
    }

    public static void main(String[] args) {
        String[] words = {"leetcode", "leede", "leem"};
        System.out.println(getLongestCommonPrefix(words));
    }
}
