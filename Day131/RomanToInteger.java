package Day131;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    public static void main(String[] args) {
        System.out.println(romanToInteger("CMXCIV"));

    }
    private static int romanToInteger(String s) {
        Map<String, Integer> map = new HashMap<>();
        map.put("M", 1000);
        map.put("D", 500);
        map.put("C", 100);
        map.put("L", 50);
        map.put("X", 10);
        map.put("V", 5);
        map.put("I", 1);

        String lastSym = s.substring(s.length() - 1);
        int lastVal = map.get(lastSym);
        int total = lastVal;
        for (int i = s.length() - 2; i >= 0; i--) {
            String curSym = s.substring(i, i + 1);
            int curVal = map.get(curSym);

            if (curVal < lastVal) {
                total -= curVal;
            } else {
                total += curVal;
            }
            lastVal = curVal;
        }
        return total;
    }
}
