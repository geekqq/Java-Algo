package Day38;

public class LongestSubstring {
    public static void main(String[] args) {
        System.out.println(getLengthOfLengthSubstring("JinweiHu"));
    }

    public static int getLengthOfLengthSubstring(String s) {
        int maxLength = 0;
        String test = "";
        char[] chars = s.toCharArray();
        for (char c : chars) {
            String current = String.valueOf(c);
            if (test.contains(current)) {
                test = test.substring(test.indexOf(current) + 1);
            }
            test += current;
            maxLength = Math.max(maxLength, test.length());
        }
        return maxLength;
    }
}
