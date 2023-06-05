package Day238;

import java.util.HashMap;
import java.util.Map;

public class NewRomanToInt {

    public static final Map<Character, Integer> MAP = Map.of(
            'M', 1000,
            'D', 500,
            'C', 100,
            'L', 50,
            'X', 10,
            'V', 5,
            'I', 1
    );

    public static int romanToInt(String s) {
        if (s == null || s.length() == 0) return -1;
        Character lastSym = s.charAt(s.length() - 1);
        int lastVal = MAP.get(lastSym);
        int sum = lastVal;
        for (int i = s.length() - 2; i >= 0; i--) {
            Character curSym = s.charAt(i);
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
        System.out.println(romanToInt("VII"));
    }
}
