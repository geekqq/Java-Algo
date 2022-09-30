package Day23;

import java.util.Arrays;

public class DemoCharArray {
    public static void main(String[] args) {
        String s = "helllpo!";
        char[] chars = s.toCharArray();
        System.out.println(chars);
        System.out.println(Arrays.toString(chars));
        for (char c : chars) {
            System.out.print(c);
        }
        for (int i = chars.length - 1; i >= 0 ; i--) {
            System.out.print(chars[i]);
        }
    }
}
