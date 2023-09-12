package Day293;

public class IsIndexOf {

    public static int isIndexOf(String s, String t) {
        if (s == null || t == null) return -1;
        if (s.length() == 0 || t.length() == 0) return -1;
        if (s.length() < t.length()) {
            return isIndexOf(t, s);
        }

        int m = s.length();
        int n = t.length();

        for (int i = 0; i <= m - n; i++) {
            boolean isSubstring = true;
            for (int j = 0; j < n; j++) {
                if (s.charAt(i + j) != t.charAt(j)) {
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
        System.out.println(isIndexOf("hoo", ""));
    }
}
