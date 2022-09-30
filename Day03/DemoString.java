package Day03;

public class DemoString {
    public static void main(String[] args) {
//        StringBuilder s = new StringBuilder("hello World!");
        String s = "hello";
        System.out.println((char)(65));
        System.out.println((char)(97));
        System.out.println(reverseString(s));
        System.out.println('A' + "hello");
    }

    public static String reverseString(String s) {
        String reversed = "";
        for (int i = s.length() - 1; i >= 0 ; i--) {
            reversed += s.charAt(i);
        }
        return reversed;
    }
}
