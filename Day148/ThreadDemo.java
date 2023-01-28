package Day148;

public class ThreadDemo {
    public static void main(String[] args) {
        Thread t = new Thread() {
            @Override
            public void run() {
                System.out.println("haha");
            }
        };
        t.start();
        System.out.println("xixi");
    }
}
