package Day247;

public class GetBytesDemo {

    public static void main(String[] args) {
        String s = "hello";
        byte[] hash = s.getBytes();
        for (byte b : hash) {
            System.out.print(b + " ");
        }
        System.out.println();
        for (int i = 0; i < s.length(); i++) {
            int n = s.charAt(i);
            System.out.print(n + " ");
        }
    }
}
