package Day284;

public class IsIndexOf {

    public static int isIndexOf(String longStr, String shortStr) {
        if (longStr == null || shortStr == null) return -1;
        int m = longStr.length();
        int n = shortStr.length();
        for (int i = 0; i <= m - n; i++) {
            boolean isSubstring = true;
            for (int j = 0; j < n; j++) {
                if (longStr.charAt(i + j) != shortStr.charAt(j)) {
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
    }
}
