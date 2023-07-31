package Day264;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.util.Collections.swap;

public class ShuffleList {

    public static void shuffleList(List<Integer> list) {
        if (list == null || list.size() == 0) return;
        int n = list.size();
        for (int i = n - 1; i > 0; i--) {
            Random rd = new Random();
            int j = rd.nextInt(i);
            swap(list, i, j);
        }
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(5);
        list.add(1);
        list.add(4);
        list.add(7);
        System.out.println(list);
        shuffleList(list);
        System.out.println(list);
    }
}
