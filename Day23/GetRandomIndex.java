package Day23;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GetRandomIndex {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);
        System.out.println(list);
        System.out.println(getRandomElement(list, 3));
    }

    public static List<Integer> getRandomElement(List<Integer> list, int totalItems) {
        Random rand = new Random();
        List<Integer> newList = new ArrayList<>();
        for (int i = 0; i < totalItems; i++) {
            int index = rand.nextInt(list.size());
            newList.add(list.get(index));
        }
        return newList;
    }
}
