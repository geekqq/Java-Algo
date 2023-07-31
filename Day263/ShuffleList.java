package Day263;

import java.util.*;

import static java.util.Collections.swap;

public class ShuffleList {

    public static void shuffleList(List<Integer> list) {

        Random rd = new Random();
        int n = list.size();
        for (int i = n - 1; i > 0; i--) {
            int j = rd.nextInt(i);
            swap(list, i, j);
        }
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 11; i++) {
            list.add(i);
        }
        System.out.println(list);
        shuffleList(list);
        System.out.println(list);
        System.out.println("========using API to shuffle==========");
        List<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < 11; i++) {
            list2.add(i);
        }
        Collections.shuffle(list2);
        System.out.println(list2);
        System.out.println(Character.valueOf('c'));
        System.out.println("------list--------");
        List<Character> list3 = new ArrayList<>();
        Character character = ' ';
        for (int i = 32; i < 127; i++) {
            list3.add(Character.valueOf(character));
            character++;
        }
        System.out.println(list);
    }

}
