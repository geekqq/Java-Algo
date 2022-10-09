package Day37;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class UnionArraysDemo {
    public static void main(String[] args) {
        String[] arr1 = {"1","2","3"};
        String[] arr2 = {"4","5","6","3"};
        String[] newArr = union(arr1, arr2);
        System.out.println(Arrays.toString(newArr));
    }

    public static String[] union(String[] arr1, String[] arr2) {
        Set<String> mySet = new HashSet<>();
        for (String s : arr1) {
            mySet.add(s);
        }
        for (String s : arr2) {
            mySet.add(s);
        }
        String[] result = {};
        return mySet.toArray(result);
    }
}
