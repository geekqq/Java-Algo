package Day325;

public class IsIndexOf {

    public static int isIndexOf(String s1, String s2) {
        if (s1 == null || s2 == null) return -1;
        if (s1.length() < s2.length()) return isIndexOf(s2, s1);
        int l1 = s1.length();
        int l2 = s2.length();
        for (int i = 0; i <= l1 - l2; i++) {
            boolean isSubstring = true;
            for (int j = 0; j < l2; j++) {
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
        System.out.println(isIndexOf("hoo", "stonehoo"));
        System.out.println(isIndexOf("stonehoo", "hoo"));
    }
}
