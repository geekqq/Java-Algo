package Day300;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PermutationPalindrome {

    public static boolean permutePalindrome(String s) {
        if (s == null || s.length() == 0) return false;
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

    public static boolean permutePalindromeSet(String s) {
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (!set.contains(c)) set.add(c);
            else set.remove(c);
        }
        return set.size() <= 1;
    }

    public static boolean permutePalindromeCount(String s) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        int odd = 0;
        for (int i : count) {
            if ((i & 1) == 1) odd++;
        }
        return odd <= 1;
    }

    public static void main(String[] args) {
        System.out.println(permutePalindrome("eta"));
        System.out.println(permutePalindrome("code"));
        System.out.println(permutePalindrome("cerarec"));
        System.out.println(permutePalindrome("aab"));
        System.out.println(permutePalindromeSet("eta"));
        System.out.println(permutePalindromeSet("code"));
        System.out.println(permutePalindromeSet("cerarec"));
        System.out.println(permutePalindromeSet("aab"));
        System.out.println(permutePalindromeCount("eta"));
        System.out.println(permutePalindromeCount("code"));
        System.out.println(permutePalindromeCount("cerarec"));
        System.out.println(permutePalindromeCount("aab"));
    }
}
