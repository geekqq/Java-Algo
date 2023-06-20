package Day247;

import java.security.MessageDigest;
import java.util.Scanner;

public class SHA256Demo {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(s.getBytes());
        byte[] hash = md.digest();

        for (byte b : hash) {
            System.out.format("%02x", b);
        }


    }
}
