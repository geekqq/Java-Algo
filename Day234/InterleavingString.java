package Day234;

import java.util.HashSet;
import java.util.Set;

public class InterleavingString {

    //LC97
    public static boolean isInterleave(String s1, String s2, String s3) {
        if (s1 == null && s2 == null && s3 == null) return true;
        if (s1 == null || s2 == null || s3 == null) return false;

        if (s1.length() + s2.length() != s3.length()) return false;

        Set<Integer> visited = new HashSet<>();

        return isInterleave(s1, 0, s2, 0, s3, 0, visited);
    }

    private static boolean isInterleave(String s1, int i1, String s2, int i2, String s3, int i3, Set<Integer> visited) {
        int hash = i1 + i2 * s3.length();

        if (visited.contains(hash)) return false;

        if (i1 == s1.length()) return s2.substring(i2).equals(s3.substring(i3));
        if (i2 == s2.length()) return s1.substring(i1).equals(s3.substring(i3));

        if (s1.charAt(i1) == s3.charAt(i3) && isInterleave(s1, i1 + 1, s2, i2, s3,i3 + 1, visited) ||
        s2.charAt(i2) == s3.charAt(i3) && isInterleave(s1, i1, s2, i2 + 1, s3, i3 + 1, visited))
            return true;
        visited.add(hash);
        return false;
    }
}

