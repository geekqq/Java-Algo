package Day37;

import java.util.ArrayList;
import java.util.List;

public class MergeTwoSortedArray {
    public static void main(String[] args) {
        int[] array1 = {5,6,7,9};
        int[] array2 = {4,5,8};

        //this is wrong, not returning a sorted array
        int i = 0;
        int j = 0;
        List<Integer> list = new ArrayList<>();
        while (i < array1.length && j < array2.length) {
            if (array1[i] < array2[j]) {
                list.add(array1[i]);
                i++;
            } else {
                list.add(array2[j]);
                j++;
            }
        }
        while (i < array1.length) {
            list.add(array1[i++]);
        }
        while (j < array2.length) {
            list.add(array2[j++]);
        }
        System.out.println(list);
    }
}
