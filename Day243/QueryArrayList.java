package Day243;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QueryArrayList {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<List<Integer>> arr = new ArrayList<>();
        while (n-- > 0) {
            int m = Integer.parseInt(sc.next());
            ArrayList<Integer> subArr = new ArrayList<>(m);

            for (int i = 0; i < m; i++) {
                subArr.add(Integer.valueOf(sc.next()));
            }
            arr.add(subArr);
        }
        int q = sc.nextInt();
        while (q-- > 0) {
            int x = Integer.valueOf(sc.next());
            int y = Integer.valueOf(sc.next());
            try {
                System.out.println(arr.get(x - 1).get(y - 1));
            } catch (Exception e) {
                System.out.println("ERROR!");
            }
        }
    }
}
