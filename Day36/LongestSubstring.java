package Day36;

public class LongestSubstring {
    public static void main(String[] args) {
        System.out.println(getLengthOfLongestSubstring("jinweihu"));
    }

    public static int getLengthOfLongestSubstring(String s) {
        //corner case
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
