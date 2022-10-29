package OODAdv;
//正确但是不高效
public class Singleton2Class {
    private static Singleton2Class  instance = null;
    private Singleton2Class() {
    }

    public Singleton2Class getInstance() {
        synchronized (Singleton2Class.class){
            if (instance == null) {
                instance = new Singleton2Class();
            }
            return instance;
        }
    }
}
