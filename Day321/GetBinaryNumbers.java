package Day321;

import java.util.*;

public class GetBinaryNumbers {
    public static String[] binaryNumbers(int n) {
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

    public static List<String> binaryNumberStringList(int n) {
        List<String> res = new ArrayList<>();
        Queue<String> q = new LinkedList<>();
        q.offer("1");
        for (int i = 0; i < n; i++) {
            String cur = q.poll();
            res.add(cur);
            q.offer(cur + "0");
            q.offer(cur + "1");
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(binaryNumbers(8)));
        System.out.println(binaryNumberStringList(8));
    }
}
