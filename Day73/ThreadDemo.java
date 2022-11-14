package Day73;

public class ThreadDemo {
    public static void main(String[] args) {
        Thread t = new Thread(new MyRunnable());
        t.start();
    }
}

class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Start new thread!");
    }
}
