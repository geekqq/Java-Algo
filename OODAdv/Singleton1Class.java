package OODAdv;

public class Singleton1Class {
    //即高效又正确的写法
    // double null check
    private static Singleton1Class instance = null;
    private Singleton1Class() {
    }

    public Singleton1Class getInstance() {
        if (instance == null) {  // 保证高效
            synchronized (Singleton1Class.class) {
                if (instance == null) {  //保证正确
                    instance = new Singleton1Class();
                }
            }
        }
        return instance;
    }
}
