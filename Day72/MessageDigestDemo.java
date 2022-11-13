package Day72;

import java.math.BigInteger;
import java.security.MessageDigest;
public class MessageDigestDemo {
    public static void main(String[] args) throws Exception {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update("Hello".getBytes("UTF-8"));
        md.update("World".getBytes("UTF-8"));
        byte[] result = md.digest();
        System.out.println(new BigInteger(1, result).toString(16));
        System.out.println(Integer.toHexString("hello, java".hashCode()));
        System.out.println(Integer.toHexString("hello, bob".hashCode()));
        System.out.println(Integer.toHexString("AaAaAa".hashCode()));
        System.out.println(Integer.toHexString("BBAaBB".hashCode()));
        System.out.println(Integer.toHexString("java001".hashCode()));
        System.out.println(Integer.toHexString("java002".hashCode()));
        System.out.println(Integer.toHexString("java003".hashCode()));
        System.out.println(Integer.toHexString("java004".hashCode()));
    }
}
