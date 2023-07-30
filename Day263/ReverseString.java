package Day263;

import java.util.Stack;

public class ReverseString {

    public static void main(String[] args) {
        System.out.println(reverseStringSwap("jinweihu"));
        System.out.println(reverseStringUsingStack("jinweihu"));
    }

    public static String reverseStringUsingStack(String s) {
        if (s == null || s.length() == 0) return null;
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (Character c : chars) {
            stack.push(c);
        }
        for (int i = 0; i < chars.length; i++) {
            chars[i] = stack.pop();
        }
        return new String(chars);
    }

    public static String reverseStringSwap(String s) {
        if (s == null || s.length() == 0) return null;
        int left = 0;
        int right = s.length() - 1;
        char[] chars = s.toCharArray();
        while (left < right) {
            swap(chars, left++, right--);
        }
        return new String(chars);
    }

    public static void swap(char[] chars, int left, int right) {
        char temp = chars[left];
        chars[left] = chars[right];
        chars[right] = temp;
    }
}
