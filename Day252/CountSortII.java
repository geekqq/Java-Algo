package Day252;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountSortII {
    public static List<Integer> countingSort(List<Integer> list) {
        Integer[] countingArr = new Integer[100];
        Arrays.fill(countingArr, 0);
        for (int i = 0; i < list.size(); i++) {
            countingArr[list.get(i)]++;
        }
        return Arrays.asList(countingArr);
    }

    public static List<Integer> countingSortII(List<Integer> list) {
        Integer[] newArr = new Integer[100];
        Arrays.fill(newArr, 0);
        for (Integer value : list) {
            newArr[value]++;
        }
        return Arrays.asList(newArr);
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(1);
        list.add(1);
        list.add(5);
        list.add(8);
        System.out.println(list);
        System.out.println(countingSort(list));
        System.out.println(countingSortII(list));
    }
}
