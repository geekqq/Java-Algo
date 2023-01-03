package Day123;

public class NewThread {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            System.out.println("Hello!");
        });
        System.out.println("Start!");
        t.start();
        t.join(100000000);
        System.out.println("End!");
        Thread t1 = new MyThread();
        t1.start();
        Thread.sleep(1);
        t1.interrupt();
        t1.join();
        System.out.println("end");
    }
}
class MyThread extends Thread {
    public void run() {
        int n = 0;
        while (!isInterrupted()) {
            n ++;
            System.out.println(n + "hello!");
        }
    }
}
