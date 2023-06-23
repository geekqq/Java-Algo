package Day249;

public class Singleton {
    private static Singleton instance = null;
    public static String str;
    private Singleton() {};
    public Singleton getSingleInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
