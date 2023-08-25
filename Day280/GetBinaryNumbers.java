package Day280;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import static Day256.PrintStringArray.printStringArray;


public class GetBinaryNumbers {

    public static String[] getBinaryNumbers(int n) {
        if (n < 0) return null;
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
        String[] arr = getBinaryNumbers(5);
        printStringArray(arr);
    }
}
