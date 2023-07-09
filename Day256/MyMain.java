package Day256;

public class MyMain {

    public static void main(String[] args) {
        MyGenericClass myInt = new MyGenericClass<>(1);
        MyGenericClass myDouble = new MyGenericClass<>(3.14);
        MyGenericClass myChar = new MyGenericClass<>('@');
        MyGenericClass myString = new MyGenericClass<>("HELLO");

        System.out.println(myInt.getValue());
        System.out.println(myDouble.getValue());
        System.out.println(myChar.getValue());
        System.out.println(myString.getValue());
    }
}
