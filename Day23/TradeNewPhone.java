package Day23;

public class TradeNewPhone {
    public static void main(String[] args) {
        double plan1 = 8888 - 1880;
        double plan2 = 8888 * 0.75;
        System.out.println(plan1 > plan2 ? "以旧换新划算一些" : "以旧换新不划算！");
        System.out.println("-----------");
        System.out.println(getAbs(-1));
        System.out.println("-----------");
        System.out.println(gcd(18, 48));
        System.out.println(18 % 48);
        System.out.println(zdgys(18, 54));
        System.out.println(lcm(18, 54));
        System.out.println(zxgbs(13, 24));
        System.out.println(lcm(13, 24));
        System.out.println(zdgys(12,24));
        System.out.println(lcm(12, 24));
    }

    public static int getAbs(int n) {
        return n >= 0 ? n : -n;
    }

    //最大公约数
    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return a % b == 0 ? b : gcd(b, a % b);
    }

    public static int zdgys(int a, int b) {
        int min = a < b ? a : b;
        for (int i = min; i > 0 ; i--) {
            if (a % i == 0 && b % i == 0) {
                return i;
            }
        }
        //为什么这里不写return 0 程序会报错？
        return 0;
    }

    //最小公倍数
    //用两个数字的乘积除以他们的最小公倍数
    public static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    public static int zxgbs(int a, int b) {
        int max = a > b ? a : b;
        for (int i = max; ; i += max) {
            if (i % a == 0 && i % b == 0) {
                return i;
            }
        }
        //这里不写return 就不会报错？
    }
}
