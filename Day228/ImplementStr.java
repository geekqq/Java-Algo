package Day228;

public class ImplementStr {

    public static int strStr(String hayStack, String needle) {
        for (int i = 0; i < hayStack.length(); i++) {
            for (int j = 0; j < needle.length(); j++) {
                if (j == needle.length()) return i;
                if (i + j == hayStack.length()) return -1;
                if (needle.charAt(i) != hayStack.charAt(i + j)) break;
            }
        }
        return -1;
    }
}
