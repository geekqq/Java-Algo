package Day52;

public class StringDemo {
    public static void main(String[] args) {
        String str1 = new String("Rock");
        String str2 = new String("Rock");
        String str3 = new String("rock");
        System.out.println(str1.equals(str2));
        System.out.println(str1.equalsIgnoreCase(str3));

        String str4 = new String("Rock");
        String str5 = new String("Pop");
        String str6 = new String("Roll");
        String str7 = new String("Roll");
        String str8 = "Roll";
        String str9 = "Roll";
        System.out.println(str4.compareTo(str5));
        System.out.println(str6.compareTo(str7));
        System.out.println(str5.compareTo(str7));
        System.out.println(str6 == str7);
        System.out.println(str6.equals(str7));
        System.out.println(str7.equals(str8));
        System.out.println(str8 == str9);
        System.out.println(str8 == str7);
    }
}
