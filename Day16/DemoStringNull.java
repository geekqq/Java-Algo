package Day16;

public class DemoStringNull {
    public static void main(String[] args) {
        String s = null;
        System.out.println(s.valueOf(10));
        String s2 = new String("5");
        System.out.println(1 + 10 + s2 + 1 + 10);
        System.out.println("---------------");
        String s3 = "hello";
        String s4 = "hello";
        System.out.println(s3.toString() == s3);
        System.out.println(s3.toString().equals(s3));
        System.out.println("--------------");
        String s5 = "abc";
        StringBuffer s6 = new StringBuffer("abc");
        System.out.println(s5.equals(s6));
        System.out.println("---------------");
        String s7 = "Java";
        String s8 = "Java";
        StringBuilder sb7 = new StringBuilder();
        sb7.append("Ja").append("va");
        System.out.println(s7.equals(s8));
        System.out.println(s7 == s8);
        System.out.println(sb7.toString() == s7);
        System.out.println(sb7.toString().equals(s7));
        System.out.println("---------------");
        String s9 = "hello";
        System.out.println(s9.replace('l', 'L'));
        System.out.println(s9.replaceAll("l", "L"));
        System.out.println(s9.replaceFirst("l", "L"));
        System.out.println(s9);

    }
}
