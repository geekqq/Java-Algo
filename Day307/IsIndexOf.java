package Day307;

public class IsIndexOf {

    public static int indexOf(String s1, String s2) {
        if (s1 == null || s2 == null) throw new IllegalArgumentException();
        if (s1.length() < s2.length()) {
            return indexOf(s2, s1);
        }

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
        System.out.println(indexOf("stonehoo", "hoo"));
        System.out.println(indexOf("hoo", "stonehoo"));
    }
}
