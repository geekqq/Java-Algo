package Day313;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinLengthSum {

    public static int minLenGreaterSum(List<Integer> list, int target) {
        if (list == null || list.size() == 0) return -1;
        int start = 0;
        int sum = 0;
        int minLen = list.size() + 1;
        for (int end = 0; end < list.size(); end++) {
            sum += list.get(end);
            while (start <= end && sum >= target) {
                minLen = Math.min(minLen, end - start + 1);
                sum -= list.get(start++);
            }
        }
        return minLen == list.size() + 1 ? -1 : minLen;
    }

    public static void main(String[] args) {
        List<Integer> test1 = new ArrayList<>(Arrays.asList(1, 4, 45, 6, 10, 19));
        int target = 51;
        System.out.println(minLenGreaterSum(test1, target));
    }
}
