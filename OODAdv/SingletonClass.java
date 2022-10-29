package OODAdv;

//设计一个class，该class只能创建一个instance。最常用的场景是创建过程的cost比较大的时候比如cache在load时候数据可能会非常大
public class SingletonClass {
    private static SingletonClass instance = null;
    private SingletonClass() {
    }

    public static SingletonClass getInstance() {
        if (instance == null) {
            instance = new SingletonClass();
        }
        return instance;
    }
}
