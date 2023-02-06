package Day157;

public class MainThread {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.activeCount());
        Thread.currentThread().setName("MAIN");
        System.out.println(Thread.currentThread().getName());
        Thread.currentThread().setPriority(10);
        System.out.println(Thread.currentThread().getPriority());
        System.out.println(Thread.currentThread().isAlive());

        for (int i = 3; i > 0; i--) {
            System.out.println(i);
            Thread.sleep(1000);
        }
        System.out.println("you are done!");
        MyThread thread2 = new MyThread();
        thread2.setName("2nd Thread");
        System.out.println(thread2.getName());
        thread2.setPriority(1);
        System.out.println(thread2.getPriority());
    }

}
class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("This thread is running!");
    }
}