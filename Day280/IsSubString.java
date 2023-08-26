package Day280;

public class IsSubString {

    public static int isSubString(String longStr, String shortStr) {
        if (shortStr == null || longStr == null || longStr.length() < shortStr.length()) return -1;
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
        System.out.println(isSubString("lovetone", "tone"));
    }
}
