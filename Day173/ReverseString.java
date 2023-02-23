package Day173;

public class ReverseString {
    public static void main(String[] args) {
        System.out.println(reverseString("stone"));
        System.out.println(reverseStringII("jinwei"));
    }

    private static String reverseString(String s) {
        if (s == null || s.length() == 0) {
            throw new IllegalArgumentException();
        }
        int left = 0;
        int right = s.length() - 1;
        char[] chars = s.toCharArray();
        while (left < right) {
            swap(chars, left++, right--);
        }
        return String.valueOf(chars);
    }

    public static void swap(char[] chars, int left, int right) {
        char temp = chars[left];
        chars[left] = chars[right];
        chars[right] = temp;
    }

    private static String reverseStringII(String s) {
        if (s == null || s.length() == 0) return null;
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
