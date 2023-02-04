package Day155;

public class CounterDemo {
    public static void main(String[] args) {
        int c = 0;
        Thread t1 = new Thread();
        Thread t2 = new Thread();
        t1.start();
        c++;
        System.out.println(c++);
        t2.start();
        c--;
        System.out.println(c--);
    }
}
