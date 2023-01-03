package Day123;

public class ThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new MyThread1();
        t.start();
        Thread.sleep(1000);
        t.interrupt();
        t.join();
        System.out.println("end!");
    }
}
class MyThread1 extends Thread {
    public void run() {
        Thread hello = new HelloThread();
        hello.start();
        try {
            hello.join();
        } catch (InterruptedException e) {
            System.out.println("interrupted");
        }
        hello.interrupt();
    }
}
class HelloThread extends Thread {
    public void run() {
        int n = 0;
        while (!isInterrupted()) {
            n++;
            System.out.println(n + " Hello!");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
