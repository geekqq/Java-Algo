package Day242;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class HashSetDemo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        Set<String> set = new HashSet<>();

        String[] pairLeft = new String[T];
        String[] pairRight = new String[T];

        for (int i = 0; i < T; i++) {
            pairLeft[i] = sc.next();
            pairRight[i] = sc.next();
        }

        for (int i = 0; i < T; i++) {
            set.add(pairLeft[i] + " " + pairRight[i]);
            System.out.println(set.size());
        }
        sc.close();
    }
}
