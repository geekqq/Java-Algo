package Day294;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class GetBinaryNumberString {

    public static String[] getBinaryNumbers(int n) {
        if (n <= 0) throw new IllegalArgumentException();
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

    public static void main(String[] args) {
        System.out.println(Arrays.toString(getBinaryNumbers(5)));
        System.out.println(Arrays.toString(getBinaryNumbers(10)));
        System.out.println(Arrays.toString(getBinaryNumbers(100)));
    }
}
