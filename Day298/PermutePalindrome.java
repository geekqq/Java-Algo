package Day298;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PermutePalindrome {

    public static boolean permutePalindromeMap(String s) {
        if (s == null || s.length() == 0) return false;
        Map<Character, Integer> map = new HashMap<>();
        for (Character c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0 ) + 1);
        }
        int count =- 0;

        for (int i : map.values()) {
            if (i % 2 == 1) count++;
        }

        return count <= 1;
    }

    public static boolean permutePalindromeSet(String s) {
        //cc
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (!set.contains(c)) set.add(c);
            else set.remove(c);
        }
        return set.size() <= 1;
    }

    public static boolean permutePalindromeArray(String s) {
        //cc
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c- 'a']++;
        }
        int odd = 0;
        for (int i : count) {
            if (i % 2 == 1) odd++;
        }
        return odd <= 1;
    }

    public static void main(String[] args) {
        System.out.println(permutePalindromeArray("code"));
        System.out.println(permutePalindromeArray("code"));
        System.out.println(permutePalindromeArray("code"));
        System.out.println(permutePalindromeMap("cerarec"));
        System.out.println(permutePalindromeMap("cerarec"));
        System.out.println(permutePalindromeMap("cerarec"));
        System.out.println(permutePalindromeSet("aab"));
        System.out.println(permutePalindromeSet("aab"));
        System.out.println(permutePalindromeSet("aab"));
    }
}
