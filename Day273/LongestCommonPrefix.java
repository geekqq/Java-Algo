package Day273;

public class LongestCommonPrefix {

    public static String getLCP(String[] str) {
        if (str == null || str.length == 0) return null;
        String prefix = str[0];
        for (int i = 1; i < str.length; i++) {
            while (str[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }
        return prefix.isEmpty() ? null : prefix;
    }

    public static void main(String[] args) {
        String[] str = {"leet", "laedko", "leese", "leema"};
        System.out.println(getLCP(str));
    }
}
