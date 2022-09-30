package Day25;

public class isPrime {
    public static void main(String[] args) {
        for (int i = 2; i < 10000; i++) {
            if (isPrimeOne(i)) {
                System.out.print(i + " ");
            }
        }
        System.out.println();

        for (int i = 2; i < 10000; i++) {
            if (isPrimeTwo(i)) {
                System.out.print(i + " ");
            }
        }
        System.out.println();

        for (int i = 2; i < 10000; i++) {
            if (isPrimeThree(i)) {
                System.out.print(i + " ");
            }
        }
    }

    public static boolean isPrimeOne(int n) {
        if ( n <= 3) {
            //1不是质数，2和3都是i质数
            return n > 1;
        }

        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPrimeTwo(int n) {
        //如果一个数字不是质数，那么这个数一定有两个非1的约数p1和p2，其中p1 <= sqrt(n)，p2 >= sqrt(n)
        if (n <= 3) return n > 1;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPrimeThree(int n) {
        //所有的质数都有一个特点，即总是等于6x-1或者6x+1，其中x是大于等于1的自然数。
        //6x不是质数，因为能被6整除，6x+2能被2整除，6x+3能被3整除，6x+4也能被2整除，6x+5(等同于6x-1)和6x+1可能是质数。
        //以此推断，循环的步长可以设定为6，只需要判断6两侧数数字就可以了。
        if (n <= 3) return n > 1;
        if (n % 6 != 5 && n % 6 != 1) return false;
        for (int i = 5; i <= Math.sqrt(n); i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }
}
