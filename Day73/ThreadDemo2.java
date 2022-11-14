package Day73;

//使用lumbda表达式

public class ThreadDemo2 {
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            System.out.println("start new thread!");
        });
        t.start();
    }
}
