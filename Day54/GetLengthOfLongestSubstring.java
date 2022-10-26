package Day54;

public class GetLengthOfLongestSubstring {
    public static void main(String[] args) {
        System.out.println(getLengthOfLongestSubstring("jinweihuuuuuuusdadsadsadsaewad"));
    }
    public static int getLengthOfLongestSubstring(String s) {
        int maxLen = 0;
        String test = "";

        char[] chars = s.toCharArray();
        for (char c : chars) {
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
