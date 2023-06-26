package Day251;

import java.util.Scanner;

public class ExceptionHandlingDemo {

    public static final MyCalculator myCal = new MyCalculator();
    public static final Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        while (in.hasNextLine()) {
            int n = in.nextInt();
            int p = in.nextInt();

            try {
                System.out.println(myCal.power(n, p));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }


}

class MyCalculator {
    public static int power(int n, int p) throws Exception {
        if (n < 0 || p < 0) {
            throw new Exception("n or p should not be negative");
        } else if (n == 0 && p == 0) {
            throw new Exception("n and p should not be zero");
        } else {
            return (int) Math.pow(n, p);
        }
    }
}
