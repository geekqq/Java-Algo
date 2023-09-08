package Day290;

import java.util.*;

import static Day256.PrintArray.printArray;
import static Day256.RandomArray.randomArray;

public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] arr, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 2; i++) {
            int j = i + 1;
            int k = arr.length - 1;
            while (j < k) {
                List<Integer> list = new LinkedList<>();
                int sum = arr[i] + arr[j] + arr[k];
                if (sum == target) {
                    list.add(arr[i]);
                    list.add(arr[j++]);
                    list.add(arr[k--]);
                    res.add(list);
                } else if (sum < target) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = randomArray(10, 15);
        printArray(arr);
        System.out.println(threeSum(arr, 25));
        Set<List<Integer>> set = new HashSet<>();
        List<Integer> list1 = Arrays.asList(1, 2, 3);
        //List<Integer> list2 = Arrays.asList(1, 2, 3);
        List<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(2);
        list2.add(3);
        System.out.println(list1.equals(list2)); // true
        System.out.println(list1 == list2);; // false
        System.out.println(set.add(list1)); //true
        System.out.println(set.add(list2)); //false
    }
}
