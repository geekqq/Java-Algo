package Day259;

import java.util.stream.IntStream;

public class MainThreadDemo {

    public static void main(String[] args) {
        IntStream.rangeClosed(1, 15).forEach(t -> System.out.println(Thread.currentThread().getName() + " : " + t));
        System.out.println("===============");
        IntStream.rangeClosed(1, 15).parallel().forEach(t -> System.out.println(Thread.currentThread().getName() + " : " + t));
    }
}
