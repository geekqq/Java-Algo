package OODAdv;

public class Singleton1Class {
    //即高效又正确的写法
    private static Singleton1Class instance = null;
    private Singleton1Class() {
    }

    public Singleton1Class getInstance() {
        if (instance == null) {
            synchronized (Singleton1Class.class) {
                if (instance == null) {
                    instance = new Singleton1Class();
                }
            }
        }
        return instance;
    }
}
