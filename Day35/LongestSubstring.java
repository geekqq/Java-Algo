package Day35;

public class LongestSubstring {
    public static void main(String[] args) {
        String s = "qwertsdfg";
        String s1 = "o";
        System.out.println(getLengthOfLongestSubstring(s));
        System.out.println(getLengthOfLongestSubstring(s1));
    }

    public static int getLengthOfLongestSubstring(String s) {
        if (s.isEmpty()) return 0;
        int maxLength = 0;
        String test = "";
        char[] chars = s.toCharArray();
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
