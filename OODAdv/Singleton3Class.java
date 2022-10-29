package OODAdv;

public class Singleton3Class {
    //高效率但是不正确的lock写法
    private static Singleton3Class instance = null;
    private Singleton3Class() {
    }

    public Singleton3Class getInstance() {
        if (instance == null) {
            synchronized (Singleton3Class.class) {
                instance = new Singleton3Class();
            }
        }
        return instance;
    }
}
