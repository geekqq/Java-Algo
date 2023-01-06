package Day126;

public class IsPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome(100));
    }
    public static boolean isPalindrome(int x) {
        //corner case 负数false，各位是0的除了0其它都false
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int n = 0;
        while (x > n) {
            //取其个位数变成十位再加倒数第二位
            n = n * 10 + x % 10;
            x /= 10;
        }
        //比较x和n 如果相等就true
        return x == n || x == n / 10;
    }
}
