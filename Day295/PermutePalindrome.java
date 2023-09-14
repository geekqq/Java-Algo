package Day295;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PermutePalindrome {


    public static boolean canPermutePalindromeMap(String s) {
        if (s == null || s.length() == 0) return false;
        Map<Character, Integer> map = new HashMap<>();
        for (Character c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int count = 0;
        for (int i : map.values()) {
            if (i % 2 == 1) count++;
        }
        return count <= 1;
    }

    public static boolean canPermutePalindromeSet(String s) {
        if (s == null || s.length() == 0) return false;
        Set<Character> set = new HashSet<>();
        for (Character c : s.toCharArray()) {
            if (!set.contains(c)) set.add(c);
            else set.remove(c);
        }
        return set.size() <= 1;
    }

    public static void main(String[] args) {
        System.out.println(canPermutePalindromeMap("122121321"));
        System.out.println(canPermutePalindromeSet("122121321"));
        System.out.println(canPermutePalindromeMap("code"));
        System.out.println(canPermutePalindromeMap("aab"));
        System.out.println(canPermutePalindromeMap("carerac"));
        System.out.println(canPermutePalindromeSet("code"));
        System.out.println(canPermutePalindromeSet("aab"));
        System.out.println(canPermutePalindromeSet("carerac"));
    }
}
