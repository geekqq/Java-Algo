package Day45;

public class DeleteCharAtString {
    public static void main(String[] args) {
        String str = " hello";
        System.out.println(removeCharAt(str, 3));
        System.out.println(removeCharAt("Jinwei", 1));
    }
    public static String removeCharAt(String s, int pos) {
        return s.substring(0,pos) + s.substring(pos + 1);
    }
}
