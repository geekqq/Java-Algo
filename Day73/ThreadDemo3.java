package Day73;

public class ThreadDemo3 {
    public static void main(String[] args) {
        System.out.println("main thread start...");
        Thread t = new Thread() {
            public void run() {
                System.out.println("thread run...");
                System.out.println("thread end.");
            }
        };
        t.start();
        System.out.println("main thread ends.");
    }
}
