package Day192;

import static Day149.RomanToInteger.MAP;

public class RomanToInt {

    public static void main(String[] args) {
        System.out.println(romanToInt("CMXI"));
        System.out.println(romanToIntII("CMXI"));
    }

    public static int romanToInt(String s) {
        if (s == null || s.length() == 0) return 0;
        int i = 0;
        int sum = 0;
        while (i < s.length()) {
            String curSym = s.substring(i, i + 1);
            int curVal = MAP.get(curSym);
            int nextVal = 0;
            if (i + 1 < s.length()) {
                String nextSym = s.substring(i + 1, i + 2);
                nextVal = MAP.get(nextSym);
            }
            if (nextVal > curVal) {
                sum += nextVal - curVal;
                i += 2;
            } else {
                sum += curVal;
                i++;
            }
        }
        return sum;
    }

    public static int romanToIntII(String s) {
        if (s == null || s.length() == 0) return 0;
        String lastSym = s.substring(s.length() - 1);
        int lastVal = MAP.get(lastSym);
        int sum = lastVal;
        for (int i = s.length() - 2; i >= 0; i--) {
            String curSym = s.substring(i, i + 1);
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

