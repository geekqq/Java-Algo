package Day250;

public class LongestCommonPrefix {

    public static String getCommonPrefix(String[] str) {
        if (str == null || str.length == 0) return null;
        String prefix = str[0];
        for (int i = 1; i < str.length; i++) {
            while (str[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.length() == 0) {
                    return null;
                }
            }
        }
        return prefix;
    }

    public static void main(String[] args) {
        String[] str = {"hello", "hehsda", "hem", "hexdas"};
        System.out.println(getCommonPrefix(str));
    }
}
