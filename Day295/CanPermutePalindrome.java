package Day295;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CanPermutePalindrome {

    public static boolean canPermutePalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int count = 0;
        for (int i : map.values()) {
            if (i % 2 == 1) count++;
        }
        return count <= 1;
    }

    public static boolean canPermutePalindromeSet(String s) {
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (!set.contains(c)) set.add(c);
            else set.remove(c);
        }
        return set.size() <= 1;
    }


    public static void main(String[] args) {
        System.out.println(canPermutePalindrome("122121321"));
        System.out.println(canPermutePalindromeSet("122121321"));
        System.out.println(canPermutePalindrome("code"));
        System.out.println(canPermutePalindrome("aab"));
        System.out.println(canPermutePalindrome("carerac"));
        System.out.println(canPermutePalindromeSet("code"));
        System.out.println(canPermutePalindromeSet("aab"));
        System.out.println(canPermutePalindromeSet("carerac"));
    }
}
