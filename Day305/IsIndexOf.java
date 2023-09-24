package Day305;

public class IsIndexOf {

    public static int indexOf(String s1, String s2) {
        if (s1 == null || s2 == null) return -1;
        int m = s1.length();
        int n = s2.length();
        if (m < n) return indexOf(s2, s1);
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
