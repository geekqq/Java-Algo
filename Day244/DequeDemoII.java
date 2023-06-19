package Day244;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Scanner;

public class DequeDemoII {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        Deque<Integer> deque = new ArrayDeque<>();
        HashMap<Integer, Integer> map = new HashMap();
        int max = 0;
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            if (i >= m) {
                int first = deque.removeFirst();
                map.put(first, map.get(first) - 1);
                if (map.get(first) == 0) {
                    map.remove(first);
                }
            }
            deque.addLast(num);
            map.put(num, map.get(num) == null ? 1 : map.get(num) + 1);
            max = Math.max(max, map.size());
            if (max == m) break;
        }
        System.out.println(max);
    }
}
