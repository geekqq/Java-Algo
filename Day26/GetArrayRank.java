package Day26;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class GetArrayRank {
    public static void main(String[] args) {
        int[] arr = {30,20,30,50,10,40};
        System.out.println(Arrays.toString(getArrayRank(arr)));
    }

    public static int[] getArrayRank(int[] nums) {
        int[] newArr = Arrays.copyOfRange(nums, 0, nums.length);
        int rank = 1;
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.sort(newArr);

        for (int i = 0; i < newArr.length; i++) {
            if (!map.containsKey(newArr[i])) {
                map.put(newArr[i], rank);
                rank++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = map.get(nums[i]);
        }
        return nums;
    }
}
