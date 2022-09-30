package Day11;

public class StringReverse {
    public static void main(String[] args) {
        String s = "Hello";
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
        }
        System.out.println(sb);
        sb.reverse();
        System.out.println(sb);
        System.out.println("--------");
        String str = "Codesignal";
        String reverse = reverseStringSwap(str);
        System.out.println(reverse);
    }

    public static String reverseStringSwap(String s) {
        int left = 0, right = s.length() - 1;
        //StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        for (left = 0; left < right ; left++, right--) {
            char temp = chars[right];
            chars[right] = chars[left];
            chars[left] = temp;
        }
        return String.valueOf(chars);
    }
}
