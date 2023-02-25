package Day176;

public class ReverseString {
    public static void main(String[] args) {
        System.out.println(reverseString("jinweihu"));
    }
    private static String reverseString(String s) {
        if (s == null || s.length() == 0) return null;
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
