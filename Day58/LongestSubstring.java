package Day58;

public class LongestSubstring {
    public static void main(String[] args) {
        System.out.println(getLengthOfLongestSubstring("jinweihu"));
    }

    public static int getLengthOfLongestSubstring(String s) {
        int maxLen = 0;
        String test = "";

        char[] cahrs = s.toCharArray();
        for (char c : cahrs) {
            String cur = String.valueOf(c);
            if (test.contains(cur)) {
                test = test.substring(test.indexOf(cur) + 1);
            }
            test += cur;
            maxLen = Math.max(maxLen, test.length());
        }
        return maxLen;
    }
}
