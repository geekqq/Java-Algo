package Day266;

public class RecursionDemo {

    public static void printNum(int num) {
        if (num == 0) return;
        System.out.println(num);
        printNum(num - 1);
    }



    public static int catEyes(int cats) {
        if (cats == 0) return 0;
        return catEyes(cats - 1) + 2;
    }


    public static void main(String[] args) {
        printNum(15);
        System.out.println(catEyes(4));
        System.out.println(power(3, 4));
        System.out.println("---factorial---");
        System.out.println(factorial(5));
        System.out.println("---fibonacci numbers---");
        System.out.println(fibonacci(5));
        for (int i = 0; i < 15; i++) {
            System.out.print(fibonacci(i) + " ");
        }
        System.out.println("---mobile phone speakers---");
        System.out.println(speakers(4));

        System.out.println("---digit sum---");
        System.out.println(digitSum(1234));

        System.out.println("---count five---");
        System.out.println(countFive(1523525));
    }

    public static int power(int base, int num) {
        if (num == 1) return base;
        else return base * power(base, num - 1);
    }

    public static int factorial(int num) {
        if (num == 1 || num == 0) return 1;
        return factorial(num - 1) * num;
    }

    public static int fibonacci(int num) {
        if (num == 0) return 0;
        if (num == 1) return 1;
        return fibonacci(num - 1) + fibonacci(num - 2);
    }

    public static int speakers(int mobiles) {
        if (mobiles == 0) return 0;
        else {
            if ((mobiles & 1) == 0) {
                return 2 + speakers(mobiles - 1);
            } else {
                return 1 + speakers(mobiles - 1);
            }
        }
    }

    public static int digitSum(int num) {
        if (num == 0 || num == 1) return num;
        return digitSum(num / 10) + num % 10;
    }

    public static int countFive(int num) {
        if (num == 0) return 0;
        if (num == 5) return 1;
        if (num % 10 == 5) {
            return 1 + countFive(num / 10);
        } else {
            return countFive(num / 10);
        }
    }
}
