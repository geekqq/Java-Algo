package Day279;

import java.util.Set;

public class RemoveVowels {

    public static String removeVowels(String s) {
        if (s == null || s.length() == 0) return null;
        char[] chars = s.toCharArray();
        int i = 0;
        int j = 0;
        Set<Character> set = Set.of('a', 'e', 'i', 'o', 'u');
        while (i < chars.length) {
            if (!set.contains(chars[i])) {
                chars[j++] = chars[i++];
            } else {
                i++;
            }
        }
        return new String(chars).substring(0, j);
    }

    public static String removeVowelsI(String s) {
        if (s == null || s.length() == 0) return null;
        Set<Character> set = Set.of('a', 'e', 'i', 'o', 'u');
        StringBuilder sb = new StringBuilder();
        for (Character c : s.toCharArray()) {
            if (!set.contains(c)) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(removeVowels("hello"));
        System.out.println(removeVowelsI("hello"));
        System.out.println(removeVowelsI("renmove"));
        System.out.println(removeVowels("renmove"));
    }
}
