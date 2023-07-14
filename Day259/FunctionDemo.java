package Day259;

import java.util.function.Function;

public class FunctionDemo {

    public static void main(String[] args) {
        Function function = (t) -> {
            return "output: " + t;
        };

        System.out.println(function.apply(15));
    }
}
