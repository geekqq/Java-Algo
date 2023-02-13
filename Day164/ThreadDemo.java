package Day164;

import java.sql.SQLOutput;

public class ThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.activeCount());
        Thread.currentThread().setName("MAINNNNNNNN");
        System.out.println(Thread.currentThread().getName());
        Thread.currentThread().setPriority(10);
        System.out.println(Thread.currentThread().getPriority());
        System.out.println(Thread.currentThread().isAlive());
        for (int i = 3; i > 0; i--) {
            System.out.println(i);
            Thread.sleep(1000);
        }
        System.out.println("You are done!");

        MyThread thread2 = new MyThread();
        thread2.start();
        System.out.println("is thread2 alive? " + thread2.isAlive());
        System.out.println(thread2.getName());
        thread2.setPriority(5);
        System.out.println(thread2.getPriority());
        System.out.println(Thread.activeCount());
        System.out.println(thread2.isDaemon());
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("This thread 2 is running!");
    }
}