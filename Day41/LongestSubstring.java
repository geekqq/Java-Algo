package Day41;

public class LongestSubstring {
    public static void main(String[] args) {
        System.out.println(getLengthOfLongestSubstring("jiwneihu"));
    }
    public static int getLengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int maxLength = 0;
        String test = "";

        for (char c : chars) {
            String current = String.valueOf(c);
            if (test.contains(current)) {
                test = test.substring(test.indexOf(current) + 1);
            }
            test += current;
            maxLength = Math.max(test.length(), maxLength);
        }
        return maxLength;
    }
}
