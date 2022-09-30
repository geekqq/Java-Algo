package Day13;

public class DemoStringReplace {
    public static void main(String[] args) {
        String s = " hello ";
        System.out.println(s.replaceAll(" ", "x"));
        System.out.println(s);
        System.out.println("==============");
        String phone = "800gotjunk";
        String number = phone.replaceAll("[ABCabc]", "2");
         number = number.replaceAll("[DEFdef]", "3");
         number = number.replaceAll("[GHIghi]", "4");
         number = number.replaceAll("[JKLjkl]", "5");
         number = number.replaceAll("[MNOmno]", "6");
         number = number.replaceAll("[PQRSpqrs]", "7");
         number = number.replaceAll("[TUVtuv]", "8");
         number = number.replaceAll("[WXYZwxyz]", "9");
        System.out.println(number);
    }
}
