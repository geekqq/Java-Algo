package Day28;

public class isFlippedString {
    public static void main(String[] args) {
        String s1 = "waterbottle";
        String s2 = "erbottlewat";
        System.out.println(isFlippedString(s1, s2));
    }

    public static boolean isFlippedString(String s1, String s2) {
        return s1.length() == s2.length() && (s2 + s2).contains(s1);
    }
}
