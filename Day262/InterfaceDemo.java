package Day262;

public class InterfaceDemo {
    public static void main(String[] args) {
        String name = "Bro";
        char symbol = '!';

        MyInterface myInterface = (n, m) ->
        {
            System.out.println("heello world!");
            System.out.println("It is sunny today, no? " + n + m);
        };
        myInterface.message(name, symbol);

        System.out.println("========================");
        MyInterface myInterface2 = (x, y) -> {
            System.out.println("Hello " + x + y);
        };
        myInterface2.message(name, symbol);
    }
}
