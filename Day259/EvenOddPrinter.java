package Day259;

import java.util.concurrent.CompletableFuture;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class EvenOddPrinter {

    public static Object object = new Object();
    private static IntPredicate oddCondition = i -> (i & 1) == 1;
    private static IntPredicate evenCondition = i -> (i & 1) == 0;
    public static void main(String[] args) throws InterruptedException {
        CompletableFuture.runAsync(() -> EvenOddPrinter.printNumber(oddCondition));
        CompletableFuture.runAsync(() -> EvenOddPrinter.printNumber(evenCondition));
        Thread.sleep(1000);
    }

    public static void execute(int no) {
        synchronized (object) {
            try {
                System.out.println(Thread.currentThread().getName() + ": " + no);
                object.notify();
                object.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void printNumber(IntPredicate condition) {
        IntStream.rangeClosed(1, 10).filter(condition).forEach(EvenOddPrinter::execute);
    }
}
