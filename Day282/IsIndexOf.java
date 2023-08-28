package Day282;

public class IsIndexOf {

    public static int isIndexOf(String longStr, String shortStr) {
        if (longStr == null || shortStr == null) throw new IllegalArgumentException();
        int m = longStr.length();
        int n = shortStr.length();
        for (int i = 0; i <= m - n; i++) {
            boolean isSubString = true;
            for (int j = 0; j < n; j++) {
                if (longStr.charAt(i + j) != shortStr.charAt(j)) {
                    isSubString = false;
                    break;
                }
            }
            if (isSubString) return i;
        }
        return -1;
    }
}
