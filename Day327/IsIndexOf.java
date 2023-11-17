package Day327;

public class IsIndexOf {

    public static int isIndexOf(String s1, String s2) {
        if (s1 == null || s2 == null) return -1;
        if (s1.length() < s2.length()) return isIndexOf(s2, s1);
        int m = s1.length();
        int n = s2.length();
        for (int i = 0; i <= m - n; i++) {
            boolean isSubstring = true;
            for (int j = 0; j < n; j++) {
                if (s1.charAt(i + j) != s2.charAt(j)) {
                    isSubstring = false;
                    break;
                }
            }
            if (isSubstring) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(isIndexOf("stonehoo", "hoo"));
        System.out.println(isIndexOf("hoo", "stonehoo"));
    }
}
