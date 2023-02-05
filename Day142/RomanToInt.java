package Day142;

import java.util.Map;

public class RomanToInt {
    public static void main(String[] args) {
        System.out.println(romanToInt("CMXCIV"));
        System.out.println(romanToInt2("CMXCIV"));
    }

    private static final Map<String, Integer> MAP = Map.of(
            "M", 1000,
            "D", 500,
            "C", 100,
            "L", 50,
            "X", 10,
            "V", 5,
            "I", 1
    );
    private static int romanToInt(String s) {
        if (s == null || s.length() == 0) return 0;

        int i = 0;
        int sum = 0;
        while (i < s.length()) {
            String curSym = s.substring(i, i+1);
            int curVal = MAP.get(curSym);
            int nextVal = 0;
            if (i + 1 < s.length()) {
                String nextSym = s.substring(i +1, i +2);
                nextVal = MAP.get(nextSym);
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
        if (s == null || s.length() == 0) return 0;
        String lastSym = s.substring(s.length() - 1);
        int lastVal = MAP.get(lastSym);
        int sum = lastVal;
        for (int i = s.length() - 2; i >= 0 ; i--) {
            String curSym = s.substring(i, i +1);
            int curVal = MAP.get(curSym);
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
