package Day30;

public class StringIndexOf {
    public static void main(String[] args) {
        String myStr = "Hello planet earth, you are a great planet.";
        System.out.println(myStr.indexOf("e", 5));
        System.out.println(myStr.indexOf('e', 5));
        System.out.println(myStr.indexOf("e"));
        System.out.println(myStr.indexOf('e'));
    }
}
