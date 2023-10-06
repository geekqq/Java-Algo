package Day316;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static Day256.PrintArray.printArray;

public class RemoveDuplicatesArray {
    public static int[] removeDuplicatesArray(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int i : arr) {
            set.add(i);
        }
        int[] res = new int[set.size()];
        int index = 0;
        for (int i : set) {
            res[index++] = i;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,3,3,4,5,5,6};
        int[] res = removeDuplicatesArray(arr);
        printArray(res);
    }
}
