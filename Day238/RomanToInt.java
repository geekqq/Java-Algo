package Day238;

import static Day149.RomanToInteger.MAP;

public class RomanToInt {
    public static int romanToInt(String s) {
        if (s == null || s.length() == 0) return -1;
        char lastSym = s.charAt(s.length() - 1);
        int lastVal = MAP.get(lastSym);
        int sum = lastVal;
        for (int i = s.length() - 2; i >= 0; i--) {
            char curSym = s.charAt(i);
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

    public static int romanToIntSubstring(String s) {
        if (s == null || s.length() == 0) return -1;
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

    public static void main(String[] args) {
        System.out.println(romanToIntSubstring("III"));
    }
}
