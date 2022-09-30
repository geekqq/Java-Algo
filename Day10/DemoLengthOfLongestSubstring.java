package Day10;

import java.util.HashSet;
import java.util.Set;

public class DemoLengthOfLongestSubstring {
    public static void main(String[] args) {
        String s = "Jinwei Hu";
        int maxLength = getLengthOfLongestSubstring(s);
        System.out.println("The length of the longest substring of " + s + " is: " + maxLength);
    }

    public static int getLengthOfLongestSubstring(String s) {
        //Using set to get the duplicate character
        int left = 0, right = 0, maxLength = 0;
        Set<Character> set = new HashSet<>();
        while (right < s.length()) {
            char c = s.charAt(right);
            if (set.add(c)) {
                maxLength = Math.max(maxLength, set.size());
                right++;
            } else {
                set.remove(s.charAt(left));
                left++;
            }
        }
        return maxLength;
    }
}
