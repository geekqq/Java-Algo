package Day281;

public class IsIndexOf {

    public static int getIndexOf(String longStr, String shortStr) {
        if (longStr == null || shortStr == null) throw new IllegalArgumentException();
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
        System.out.println(getIndexOf("stonehoo", "hoo"));
    }
}
