package Day288;

public class IsIndexOf {

    public static int indexOf(String s, String t) {
        if (s == null || t == null) return -1;
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
        System.out.println(indexOf("stonehoo", "hoo"));
    }
}
