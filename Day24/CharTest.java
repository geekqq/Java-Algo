package Day24;

public class CharTest {
    public static void main(String[] args) {
        char ch1 = '\u2025';
        char ch2 = '@';
        char ch3 = ' ';
        char ch4 = '\0';
        System.out.println(ch1);
        System.out.println(ch2);
        System.out.println(ch3);
        System.out.println(Character.isSpaceChar(ch3));
        System.out.println(ch4);
    }
}
