package Day24;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class StringWithNoDuplicates {
    public static void main(String[] args) {
        String s = "hello";
        System.out.println(isStringWithDuplicates(s));
        System.out.println(ifAllCharUnique(s));
        System.out.println("---------");
        System.out.println(s.charAt(2) == s.charAt(3));
        boolean res = Objects.equals(s.charAt(2), s.charAt(3));
        System.out.println(res);

    }

    public static boolean isStringWithDuplicates(String s) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            set.add(s.charAt(i));
            if (set.size() == s.length()) {
                return true;
            }
        }
        return false;
    }

    public static boolean ifAllCharUnique( String s) {
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == (s.charAt(j))) {
                    return false;
                }
            }
        }
        return true;
    }
}
