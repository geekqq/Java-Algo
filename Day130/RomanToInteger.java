package Day130;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    public static void main(String[] args) {
        System.out.println(romanToInteger("CMXCIV"));
        System.out.println(romanToInt2("CMXCIV"));
    }

    public static int romanToInteger(String s) {
        Map<String, Integer> map = new HashMap<>();
        map.put("M", 1000);
        map.put("D", 500);
        map.put("C", 100);
        map.put("L", 50);
        map.put("X", 10);
        map.put("V", 5);
        map.put("I", 1);

        if (s == null || s.length() == 0) return 0;
        int i = 0;
        int sum = 0;
        while (i < s.length()) {
            String curSymbol = s.substring(i, i + 1);
            int curVal = map.get(curSymbol);
            if (i + 1 < s.length()) {
                String nextSymbol = s.substring(i + 1, i + 2);
                int nextVal = map.get(nextSymbol);
                if (nextVal > curVal) {
                    sum += nextVal - curVal;
                    i += 2;
                } else {
                    sum += curVal;
                    i++;
                }
            }
        }
        return sum;
    }
    public static int romanToInt2(String s) {
        Map<String, Integer> map = new HashMap<>();
        map.put("M", 1000);
        map.put("D", 500);
        map.put("C", 100);
        map.put("L", 50);
        map.put("X", 10);
        map.put("V", 5);
        map.put("I", 1);


        String lastSymbol = s.substring(s.length() - 1);
        int lastVal = map.get(lastSymbol);
        int total = lastVal;
        for (int i = s.length() - 2; i >= 0 ; i--) {
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
