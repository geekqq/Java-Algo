package Day322;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GetBinaryNumbers {

    public static List<String> getBinaryNumbers(int n) {
        if (n <= 0) return null;
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
        System.out.println(getBinaryNumbers(10));
    }
}
