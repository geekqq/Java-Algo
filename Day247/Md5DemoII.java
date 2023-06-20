package Day247;

import java.security.MessageDigest;
import java.util.Scanner;

public class Md5DemoII {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(s.getBytes());
        byte[] hash = md.digest();
        for (byte b : hash) {
            System.out.printf("%02x", b);
        }
    }
}
