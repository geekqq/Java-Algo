package Day120;

import java.util.ArrayList;
import java.util.List;

public class HailStones {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        int n = 15;
        while (n != 1) {
            list.add(n);
            if (n % 2 == 0) {
                n = n / 2;
            } else {
                n = 3*n + 1;
            }
        }
        list.add(n);
        System.out.println(list);
    }
    public static List<Integer> hailStone(int n) {
        List<Integer> list = new ArrayList<>();
        while (n != 1) {
            list.add(n);
            if (n % 2 == 0) {
                n = n / 2;
            } else {
                n = n * 3 + 1;
            }
        }
        list.add(n);
        return list;
    }
}
