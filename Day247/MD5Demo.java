package Day247;

import java.security.MessageDigest;
import java.util.Scanner;

public class MD5Demo {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        MessageDigest md5 = MessageDigest.getInstance("MD5");

        byte[] hash = md5.digest(s.getBytes());
        StringBuilder sb = new StringBuilder();
        for (byte b : hash) {
            sb.append(String.format("%02x", b));
        }
        System.out.println(sb.toString());
    }
}
