package Day76;

public class InterruptDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread();
        t.start();
        Thread.sleep(1); //暂停1毫秒
        t.interrupt(); //中断t线程
        t.join(); //等待t线程结束
        System.out.println("end");
    }
}

class MyThread extends Thread {
    public void run() {
        int n = 0;
        while (!interrupted()) {
            n++;
            System.out.println(n + "hello!");
        }
    }
}
