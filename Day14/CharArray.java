package Day14;

import java.util.Arrays;

public class CharArray {
    public static void main(String[] args) {
        String s = "！800Hello!";
        char[] chars = s.toCharArray();
        System.out.println(chars);
        System.out.println(s);
        int[] nums = {1,2,3,4,5};
        System.out.println(nums);
        System.out.println(Arrays.toString(nums));
        System.out.println(getPhoneNumber(s));

    }

    public static String getPhoneNumber(String s) {
        String sb = "";
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (!Character.isLetter(c) && !Character.isDigit(c)) {
                sb = "This is not a valid phone number!";
            } else if (Character.isLetter(c)) {
                switch(c) {
                    case 'a': case 'b': case 'c':
                        sb += "2";
                        break;
                    case 'f': case 'd': case 'e':
                        sb += "3";
                        break;
                    case 'g': case 'h': case 'i':
                        sb += "4";
                        break;
                    case 'j': case 'k': case 'l':
                        sb += "5";
                        break;
                    case 'm': case 'n': case 'o':
                        sb += "6";
                        break;
                    case 'p': case 'q': case 'r': case 's':
                        sb += "7";
                        break;
                    case 'u': case 'v': case 't':
                        sb += "8";
                        break;
                    case 'w': case 'x': case 'y': case 'z':
                        sb += "9";
                        break;
                }
            } else {
                sb += c;
            }
        }
        return sb;
    }
}
