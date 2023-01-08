package Day128;

import java.util.HashMap;
import java.util.Map;

public class RomanToIntegerLC13 {
    public static void main(String[] args) {
        System.out.println(RomanToInteger("CMXCIV"));
        System.out.println(RomanToInteger2("CMXCIV"));
    }

    public static int RomanToInteger(String s) {
        Map<String, Integer> map = new HashMap<>();
        map.put("M", 1000);
        map.put("D", 500);
        map.put("C", 100);
        map.put("L", 50);
        map.put("X", 10);
        map.put("V", 5);
        map.put("I", 1);
//        for (Map.Entry<String, Integer> set : map.entrySet()) {
//            System.out.println(set.getKey() +  " = " + set.getValue());
//        }
        String lastSymbol = s.substring(s.length() - 1);
        int lastValue = map.get(lastSymbol);
        int total = lastValue;
        for (int i = s.length() - 2; i >= 0; i--) {
            String curSymbol = s.substring(i, i + 1);
            int curValue = map.get(curSymbol);
            if (curValue < lastValue) {
                total -= curValue;
            } else {
                total += curValue;
            }
            lastValue = curValue;
        }
        return total;
    }
    public static int RomanToInteger2(String s) {
        Map<String, Integer> map = new HashMap<>();
        map.put("M", 1000);
        map.put("D", 500);
        map.put("C", 100);
        map.put("L", 50);
        map.put("X", 10);
        map.put("V", 5);
        map.put("I", 1);

        int sum = 0;
        int i = 0;
        while (i < s.length()) {
            String curSymbol = s.substring(i,i + 1);
            int curValue = map.get(curSymbol);
            int nextValue = 0;
            if (i + 1 < s.length()) {
                String nextSymbol = s.substring(i + 1, i + 2);
                nextValue = map.get(nextSymbol);
                if (nextValue > curValue) {
                    sum += nextValue - curValue;
                    i += 2;
                } else {
                    sum += curValue;
                    i++;
                }
            }
        }
        return sum;
    }
}
