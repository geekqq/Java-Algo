package Day66;

public class SingletonClass {
    private static SingletonClass instance = null;

    private SingletonClass() {
    }

    public static SingletonClass getInstance() {
        if (instance == null) {
            synchronized (SingletonClass.class) {
                if (instance == null) {
                    return new SingletonClass();
                }
            }
        }
        return instance;
    }
}
