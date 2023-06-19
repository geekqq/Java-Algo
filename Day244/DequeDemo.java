package Day244;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Scanner;

public class DequeDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Deque deque = new ArrayDeque();
        int n = sc.nextInt();
        int m = sc.nextInt();
        long max = 0;
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            deque.add(num);
            if (i >= m - 1) {
                max = Math.max(max, new HashSet<>(deque).size());
                deque.remove();
            }
            if (max == m) {
                break;
            }
        }
        System.out.println(max);
    }
}
