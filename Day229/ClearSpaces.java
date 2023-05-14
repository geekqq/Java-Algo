package Day229;

public class ClearSpaces {
    public static String clearSpaces(String s) {
        if (s == null || s.length() == 0) return s;
        char[] str = s.toCharArray();
        int i = 0;
        int j = 0;
        int n = s.length();
        while (j < n) {
            while (j < n && str[j] == ' ') j++;
            while (j < n && str[j] != ' ') str[i++] = str[j++];
            while (j < n && str[j] == ' ') j++;
            if (j < n) str[i++] = ' ';
        }
        return new String(str).substring(0, i);
    }

    public static void main(String[] args) {

        System.out.println(clearSpaces(" hello  world !  "));
    }
}
