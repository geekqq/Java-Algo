package Day45;

public class StringDemo {
    public static void main(String[] args) {
        String str = "String Runboo";
        String strUpper = str.toUpperCase();
        System.out.println(strUpper);
        String strLower = strUpper.toLowerCase();
        System.out.println(strLower);
        String str1 = "Hello World";
        System.out.println(str1.replace('H', 'W'));
        System.out.println(str1.replaceFirst("o", "E"));
        System.out.println(str1.replaceAll("o", "E"));
        System.out.println(str1.replaceAll("o", " "));
    }
}
