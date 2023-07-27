package Day262;

import java.util.HashSet;
import java.util.Set;

public class GetLengthOfSubstring {
    public static int getLength(String s) {
        //cc
        int left = 0;
        int right = 0;
        int maxLen = 0;
        Set<Character> set = new HashSet<>();
        while (right < s.length()) {
            char c = s.charAt(right++);
            if (set.add(c)) {
                maxLen = Math.max(maxLen, set.size());
            } else {
                set.remove(s.charAt(left++));
            }
        }
        return maxLen;
    }

    public static int getLengthI(String s) {
        //c
        int maxLen = 0;
        String test = "";
        for (char c : s.toCharArray()) {
            String cur = String.valueOf(c);
            if (test.contains(cur)) {
                test = test.substring(test.indexOf(cur) + 1);
            }
            test += cur;
            maxLen = Math.max(maxLen, test.length());
        }
        return maxLen;
    }
    public static void main(String[] args) {
        System.out.println(getLength("jinweihustone"));
        System.out.println(getLengthI("jinweihustone"));
    }
}
