package Day137;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    public static void main(String[] args) {
        System.out.println(romanToInt("CMXCIV"));
        System.out.println(romanToInt2("CMXCIV"));
    }



    private static int romanToInt(String s) {
        Map<String, Integer> map = new HashMap<>();
        map.put("M", 1000);
        map.put("D", 500);
        map.put("C", 100);
        map.put("L", 50);
        map.put("X", 10);
        map.put("V", 5);
        map.put("I", 1);

        int i = 0;
        int sum = 0;
        while (i < s.length()) {
            String curSym = s.substring(i, i + 1);
            int curVal = map.get(curSym);
            int nextVal = 0;
            if (i + 1 < s.length()) {
                String nextSym = s.substring(i + 1, i + 2);
                nextVal = map.get(nextSym);
            }
            if (curVal < nextVal) {
                sum += nextVal - curVal;
                i += 2;
            } else {
                sum += curVal;
                i++;
            }
        }
        return sum;
    }

    private static int romanToInt2(String s) {
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
        int sum = lastVal;
        for (int i = s.length() - 2; i >= 0 ; i--) {
            String curSym = s.substring(i, i + 1);
            int curVal = map.get(curSym);
            if (curVal < lastVal) {
                sum -= curVal;
            } else {
                sum += curVal;
            }
            lastVal = curVal;
        }
        return sum;
    }
}
