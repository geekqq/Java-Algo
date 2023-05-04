package Day224;

public class RomanToInt {
    public static int romanToInt(String s) {
        if (s == null || s.length() == 0) {
            throw new IllegalArgumentException();
        }

        int[] vals = new int[s.length()];

        for (int i = 0; i < vals.length; i++) {
            char c = s.charAt(i);
            switch (c) {
                case 'M' : vals[i] = 1000;
                break;
                case 'D' : vals[i] = 500;
                break;
                case 'C' : vals[i] = 100;
                break;
                case 'L' : vals[i] = 50;
                break;
                case 'X' : vals[i] = 10;
                break;
                case 'V' : vals[i] = 5;
                break;
                case 'I' : vals[i] = 1;
            }
        }
        int res = 0;
        for (int i = 0; i < vals.length; i++) {
            if (i == vals.length - 1) {
                res += vals[i];
            } else if (vals[i] < vals[i + 1]) {
                res -= vals[i];
            } else {
                res += vals[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("XIXI"));
        System.out.println(romanToInt("XCIX"));
    }
}
