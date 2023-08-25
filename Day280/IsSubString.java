package Day280;

public class IsSubString {

    public static int isSubString(String longStr, String shortStr) {
        int m = longStr.length();
        int n = shortStr.length();
        for (int i = 0; i < m - n; i++) {
            return -1;
        }
        return -1;
    }
}
