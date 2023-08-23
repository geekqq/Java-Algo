package Day279;

import java.util.HashSet;
import java.util.Set;

import static Day256.PrintArray.printArray;
import static Day256.RandomArray.randomArray;

public class isUniqueArray {

    public static boolean isUnique(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }
        return set.size() != arr.length;
    }

    public static boolean isUniqueI(int[] arr) {
        if (arr == null || arr.length == 0) throw new IllegalArgumentException();
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isUniqueII(int[] arr) {
        //cc
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            if (set.contains(arr[i])) {
                return true;
            }
            set.add(arr[i]);
        }
        return false;
    }
    public static void main(String[] args) {
        int[] arr = randomArray(5, 18);
        printArray(arr);
        System.out.println(isUnique(arr));
        System.out.println(isUniqueI(arr));
        System.out.println(isUniqueII(arr));
    }
}
