package Day243;

import java.lang.reflect.Method;

public class PrintArray {
    public static void main(String[] args) {
        Printer myPrinter = new Printer();
        Integer[] intArr = { 1, 2, 3 };
        String[] stringArr = { "Hello", "World"};
        myPrinter.printArray(intArr);
        myPrinter.printArray(stringArr);
        int count = 0;
        for (Method method : Printer.class.getDeclaredMethods()) {
            String name = method.getName();

            if (name.equals("printArray")) {
                count++;
            }
        }
        if (count > 1) System.out.println("Method overloading is not allowed!");
    }
}

class Printer {
    public static <E> void printArray(E[] arr) {
        for (E e : arr) {
            System.out.println(e);
        }
    }
}
