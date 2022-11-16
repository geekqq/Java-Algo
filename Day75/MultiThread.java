package Day75;

public class MultiThread {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            System.out.println("hello");
        });
        System.out.println("start");
        t.start();
        t.join(); //该语句表示需要等t线程结束运行后再继续运行main的线程
        System.out.println("end");
    }
}
