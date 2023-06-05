package Day237;

public class ClearSpaces {

    public static String clearSpaces(String s) {
        if (s == null || s.length() == 0 ) return s;
        int i = 0;
        int j = 0;
        int n = s.length();
        char[] chars = s.toCharArray();
        while (j < n) {
            while (j < n && chars[j] == ' ') j++;
            while (j < n && chars[j] != ' ') chars[i++] = chars[j++];
            while (j < n && chars[j] == ' ') j++;
            if (j < n) {
                chars[i++] = ' ';
            }
        }
        return new String(chars).substring(0, i);
    }

    public static void main(String[] args) {
        System.out.println(clearSpaces("  hello   world  "));
    }
}
