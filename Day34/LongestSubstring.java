package Day34;

public class LongestSubstring {
    public static void main(String[] args) {
        String s = "Hello!";
        System.out.println(getLengthOfLongestSubstring("jinweishudsa"));
    }

    public static int getLengthOfLongestSubstring(String s) {
        if (s.isEmpty()) return 0;
        if (s.length() == 1) return 1;

        String test = "";
        int maxLength = 0;

        for (char c : s.toCharArray()) {
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
