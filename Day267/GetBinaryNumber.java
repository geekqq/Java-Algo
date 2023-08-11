package Day267;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class GetBinaryNumber {

    public static String[] getBinaryNumber(int n) {
        if (n <= 0) return null;
        Queue<String> q = new LinkedList<>();
        q.offer("1");
        String[] res = new String[n];
        for (int i = 0; i < n; i++) {
            res[i] = q.poll();
            q.offer(res[i] + "0");
            q.offer(res[i] + "1");
        }
        return res;
    }

    public static String getBinary(int n) {
        if (n == 0) return "0";
        String res = "";
        while (n > 0) {
            String remainder = String.valueOf(n % 2);
            res = remainder + res;
            n = n / 2;
        }
        return res;
    }

    public static String getBinaryI(int n) {
        if (n == 0) return "0";
        String res = "";
        while (n > 0) {
            int remainder = n % 2;
            res = remainder + res;
            n /= 2;
        }
        return res;
    }

    public static String getBinaryBit(int n) {
        if (n == 0) return "0";
        StringBuilder sb = new StringBuilder();

        while (n > 0) {
            int bit = n & 1;
            sb.insert(0, bit);
            n >>= 1;
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        for (int i = 0; i < 11; i++) {
            System.out.println(Arrays.toString(getBinaryNumber(i)));
        }
        System.out.println();
        for (int i = 0; i < 11; i++) {
            System.out.println(getBinaryI(i));
        }
        System.out.println();
        for (int i = 0; i < 11; i++) {
            System.out.println(getBinaryBit(i));
        }
    }
}
