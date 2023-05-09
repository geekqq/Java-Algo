package Day225;

public class FactorialTrailingZeroes {
    //LC172
    //思路：末尾的0可以拆分成2*5.阶乘的质因数里明显5的数字比2的数字多很多。找到阶乘的质因数里面有多少个5，末尾就有多少个0
    //25 和125这种数字有很多个质因数5，所以除以5直到0，看有多少个5的质因数
    //S1 while循环，看每一层有多少个5的倍数，然后再把n/5直到循环结束
    public static int trailingZeroes(int n) {
        if (n < 0) {
            return -1;
        }
        int res = 0;
        while (n > 0) {
            res += n / 5;
            n /= 5;
        }
        return res;
    }

    public static int trailingZeroesI(int n) {
        if (n < 0) return -1;
        return n == 0 ? 0 : n / 5 + trailingZeroesI(n / 5);
    }
}
