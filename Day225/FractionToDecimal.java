package Day225;

import java.util.HashMap;
import java.util.Map;

public class FractionToDecimal {

    public static String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";

        StringBuilder fraction = new StringBuilder();
        //If either one is negative (not both)
        if (numerator < 0 ^ denominator < 0) {
            fraction.append("-");
        }
        //covert to Long or else abs(-2147483648) - 2 ^ 31 overflows
        Long dividend = Math.abs(Long.valueOf(numerator));
        Long divisor = Math.abs(Long.valueOf(denominator));
        fraction.append(String.valueOf(dividend / divisor));
        Long remainder = dividend % divisor;
        if (remainder == 0) {
            return fraction.toString();
        }
        fraction.append(".");
        Map<Long, Integer> map = new HashMap<>();
        while (remainder != 0) {
            if (map.containsKey(remainder)) {
                fraction.insert(map.get(remainder), "(");
                fraction.append(")");
                break;
            }
            map.put(remainder, fraction.length());
            remainder *= 10;
            fraction.append(String.valueOf(remainder / divisor));
            remainder %= divisor;
        }
        return fraction.toString();
    }

    public static void main(String[] args) {
        System.out.println(fractionToDecimal(6, 8));
    }
}
