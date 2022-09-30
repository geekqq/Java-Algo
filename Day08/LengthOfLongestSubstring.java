package Day08;

import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        String s = "heelo";
        int maxLength = getLengthOfLongestSubstring(s);
        System.out.println(maxLength);
    }

    public static int getLengthOfLongestSubstring(String s) {
        //Using set
        int left = 0, right = 0, maxLength = 0;
        //Create a set to store the character from the string
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
