package Day226;

public class ReverseString {
    public static String reverseString(String s) {
        if (s == null || s.length() == 0) return null;
        char[] chars = s.toCharArray();
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            swap(chars, left++, right--);
        }
        return new String(chars);
    }
    private static void swap(char[] chars, int left, int right) {
        //char[] chars = s.toCharArray();
        char temp = chars[left];
        chars[left] = chars[right];
        chars[right] = temp;
    }

    public static String reverseStringI(String s) {
        if (s == null || s.length() == 0) return null;
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {

        System.out.println(reverseString("hello"));
        System.out.println(reverseStringI("hello"));
    }
}
