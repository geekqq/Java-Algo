package Day320;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class GetBinaryNumbers {

    public static String[] getBinary(int n) {
        if (n <= 0) return null;
        String[] res = new String[n];
        Queue<String> q = new LinkedList<>();
        q.offer("1");
        for (int i = 0; i < n; i++) {
            res[i] = q.poll();
            q.offer(res[i] + "0");
            q.offer(res[i] + "1");
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(getBinary(9)));
    }
}
