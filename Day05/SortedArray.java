package Day05;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class SortedArray {
    public static void main(String[] args) {
        int[] arr = {4, 1, 1, 2, 3};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        int[] copy = Arrays.copyOfRange(arr, 1, 6);
        System.out.println(Arrays.toString(copy));
        System.out.println("==================");

        int[] myArr = {40,10,20,30};
        changeArr(myArr);
        System.out.println(Arrays.toString(changeArr(myArr)));
    }

    public static int[] changeArr(int[] input) {
        int[] newArray = Arrays.copyOfRange(input, 0, input.length);
        Arrays.sort(newArray);
        int i;
        Map<Integer, Integer> ranks = new HashMap<>();
        int rank = 1;
        int[] res = new int[input.length];
        for (int index = 0; index < newArray.length; index++) {
            int element = newArray[index];
            if (!ranks.containsKey(element)) {
                ranks.put(element, rank);
                rank++;
            }
        }
        for (int index = 0; index < input.length; index++) {
            //int element = input[index];
            res[index] = ranks.get(input[index]);
        }
        return res;
    }
}


