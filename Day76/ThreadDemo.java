package Day76;

public class ThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        HelloThread t = new HelloThread();
        t.start();
        Thread.sleep(1);
        t.running = false;
    }
}

class HelloThread extends Thread {
    public volatile boolean running = true;
    public void run() {
        int n = 0;
        while (running) {
            n++;
            System.out.println(n + "hello!");
        }
        System.out.println("end!");
    }
}
