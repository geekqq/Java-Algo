package Day160;

public class MultiThreadDemo {
    public static void main(String[] args) {
        MyThread thread = new MyThread();
        thread.start();
    }
}

class MyThread extends Thread {
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}


