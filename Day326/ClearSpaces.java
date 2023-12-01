package Day326;

public class ClearSpaces {

    public static String clearSpaces(String s) {
        if (s == null || s.length() == 0) return null;
        int i = 0;
        int j = 0;
        char[] chars = s.toCharArray();
        int n = s.length();
        while (j < n) {
            while (j < n && chars[j] == ' ') j++;
            while (j < n && chars[j] != ' ') chars[i++] = chars[j++];
            while (j < n && chars[j] == ' ') j++;
            if (j < n) chars[i++] = ' ';
        }
        return String.valueOf(chars).substring(0, i);
    }

    public static void main(String[] args) {
        System.out.println(clearSpaces("  jinwei hu   stone  hoo  "));
    }
}
