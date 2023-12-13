package Day328;

import java.util.*;
import java.util.LinkedList;

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

    public static List<String> getBinList(int n) {
        if (n <= 0) return null;
        List<String> list = new ArrayList<>();
        Queue<String> q = new LinkedList<>();
        q.offer("1");
        for (int i = 0; i < n; i++) {
            list.add(q.poll());
            q.offer(list.get(i) + "0");
            q.offer(list.get(i) + "1");
        }
        return list;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(getBin(5)));
        System.out.println(getBinList(5));
    }
}
