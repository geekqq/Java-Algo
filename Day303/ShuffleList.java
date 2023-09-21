package Day303;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import static java.util.Collections.list;
import static java.util.Collections.swap;

public class ShuffleList {

    public static void shuffleList(List<Integer> list) {
        if (list == null || list.size() == 0) return;
        for (int i = list.size() - 1; i > 0; i--) {
            Random rd = new Random();
            int j = rd.nextInt(i);
            swap(list, i, j);
        }
    }

    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        System.out.println(list);
        shuffleList(list);
        System.out.println(list);
    }
}
