package Day259;

public class EvenOddPrinterThread implements Runnable {

    Object object;
    static int i = 1;

    public EvenOddPrinterThread(Object object) {
        this.object = object;
    }

    @Override
    public void run() {
        while (i <= 10) {
            if ((i & 1) == 0 && Thread.currentThread().getName().equals("even")) {
                synchronized (object) {
                    System.out.println(Thread.currentThread().getName() + " : " + i);
                    i++;
                    try {
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            if ((i & 1) == 1 && Thread.currentThread().getName().equals("odd")) {
                synchronized (object) {
                    System.out.println(Thread.currentThread().getName() + " : " + i);
                    i++;
                    object.notify();
                }
            }
        }
    }

    public static void main(String[] args) {
        Object obj = new Object();
        Runnable thread1 = new EvenOddPrinterThread(obj);
        Runnable thread2 = new EvenOddPrinterThread(obj);
        new Thread(thread1, "even").start();
        new Thread(thread2, "odd").start();
    }
}
