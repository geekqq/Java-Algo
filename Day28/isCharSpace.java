package Day28;

public class isCharSpace {
    public static void main(String[] args) {
        char c1 = '$', c2 = '\u2025', c3 = '\u2028';
        boolean bool1 = Character.isSpaceChar(c1);
        System.out.println("c1 is a space character? " + bool1);
        boolean bool2 = Character.isSpaceChar(c2);
        System.out.println("c2 is a space character? " + bool2);
        boolean bool3 = Character.isSpaceChar(c3);
        System.out.println("c3 is a space character? " + bool3);
        System.out.println(c1 + "\t" + c2 + "\t" + c3 + "\t");
    }
}
