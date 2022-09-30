package Day15;

public class ReverseString {
    public static void main(String[] args) {
        String s = "hello!";
        System.out.println(reverseString(s));
        String s2 = "codedoji!";
        System.out.println(swapString(s2));
    }

    public static String reverseString(String s) {
        String newStr = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            newStr += s.charAt(i);
        }
        return newStr;
    }

    public static String swapString(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0, j = chars.length - 1; i < j; i++, j--) {
            char temp = chars[j];
            chars[j] = chars[i];
            chars[i] = temp;
        }
        return String.valueOf(chars);
    }
}
