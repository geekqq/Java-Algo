package Day250;

public class Singleton {
    private Singleton instance = null;
    private Singleton() {};
    public Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
