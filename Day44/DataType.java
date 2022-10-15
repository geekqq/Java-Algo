package Day44;

public class DataType {
    public static void main(String[] args) {
        String str1 = "123";
        int n = Integer.parseInt(str1);
        int m = Integer.valueOf(str1);
        System.out.println(n);
        System.out.println(m);

        char c = '1';
        String s = String.valueOf(c);
        System.out.println(s instanceof String);

        double db = 5.724;
        int x = (int) db;
        System.out.println(x);
    }
}
