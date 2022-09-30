package Day27;

public class StringChecker {
    public static void main(String[] args) {
        System.out.println(isFlippedString("waterbottle", "erbottlewat"));
    }

    public static boolean isFlippedString(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        s2 += s2;
        if (s2.contains(s1)) return true;
        return false;
    }
}
