package Day328;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class GetBinaryNumber {

    public static String[] getBin(int n) {
        if (n <= 0) return null;
        String[] res = new String[n];
        Queue<String> queue = new LinkedList<>();
        queue.offer("1");
        for (int i = 0; i < n; i++) {
            res[i] = queue.poll();
            queue.offer(res[i] + "0");
            queue.offer(res[i] + "1");
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(getBin(5)));
    }
}
