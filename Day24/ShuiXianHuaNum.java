package Day24;

public class ShuiXianHuaNum {
    public static void main(String[] args) {
        for (int i = 100; i < 1000; i++) {
            if (isShuiXianHuaNum(i)) {
                System.out.println(i);
            }
        }
    }

    public static boolean isShuiXianHuaNum(int n) {
        int x = n / 100;
        int y = n / 10 % 10;
        int z = n % 10;
        return n == x*x*x + y*y*y + z*z*z;
    }
}
