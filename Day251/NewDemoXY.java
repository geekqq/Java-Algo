package Day251;

import java.util.InputMismatchException;
import java.util.Scanner;

public class NewDemoXY {
    public static void main(String[] args) {
        int x = 10;
        int y = x++ + ++x;
        System.out.println(x);
        System.out.println(y);

        System.out.println("---------------");
        Scanner sc = new Scanner(System.in);

        try {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int res = a / b;
            System.out.println(res);
        } catch (ArithmeticException ae) {
            System.out.println("java.lang.ArithmeticException: / by zero");
        } catch (InputMismatchException im) {
            System.out.println("java.util.InputMismatchException");
        } catch (Exception e) {
            System.out.println("java.util.InputMismatchException");
        }
        finally {
            sc.close();
        }
    }
}
