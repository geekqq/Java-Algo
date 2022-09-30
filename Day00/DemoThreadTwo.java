package Day00;

public class DemoThreadTwo extends Thread {
    public static int amount = 0;

    public static void main(String[] args) {
        DemoThreadTwo thread = new DemoThreadTwo();
        thread.start();
        while (thread.isAlive()) {
            System.out.println("Waiting...");
        }
        System.out.println(amount);
        amount++;
        System.out.println(amount);

    }

    public void run() {
        amount++;
    }
}
