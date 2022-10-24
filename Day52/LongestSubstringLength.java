package Day52;

public class LongestSubstringLength {
    public static void main(String[] args) {
        String st = "jinweihu";
        System.out.println(getLengthOfLongestSubstring(st));
    }

    public static int getLengthOfLongestSubstring(String s) {
        int maxlen = 0;
        String test = "";

        char[] chars = s.toCharArray();
        for (char c : chars) {
            String cur = String.valueOf(c);
            if (test.contains(cur)) {
                test = test.substring(test.indexOf(cur) + 1);
            }
            test += cur;
            maxlen = Math.max(maxlen, test.length());
        }
        return maxlen;
    }
}
