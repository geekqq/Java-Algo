package Day05;

import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubString {
    public static void main(String[] args) {
        String s = "pwwkew";
        System.out.println(getLengthOfLongestSubString(s));
    }

    //Using set collections
    public static int getLengthOfLongestSubString(String s) {
        if (s == null || s.equals("")) return 0;

        int left = 0, right = 0, maxLength = 0;
        Set<Character> mySet = new HashSet<>();
        while (right < s.length()) {
            char c = s.charAt(right);
            if (mySet.add(c)) {
                right++;
                maxLength = Math.max(maxLength, mySet.size());
            } else {
                mySet.remove(s.charAt(left));
                left++;
            }
        }
        return maxLength;
    }
}