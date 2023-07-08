package Day255;

import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

public class Pair<T> {

    private final T first;
    private final T second;

    public Pair(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public T getSecond() {
        return second;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Pair.class.getSimpleName() + " [", "]")
                .add("first='" + first + "'")
                .add("second='" + second + "'")
                .toString();
    }

    public static void main(String[] args) {
        Pair<String> strings = new Pair<>("Hello", "World");
        Pair<Integer> integers = new Pair<>(42, 12);
        System.out.println(strings);
        System.out.println(integers);

        Map<String, Integer> map = new HashMap<>();
        map.put("Hello", 42);
        map.put("World", 500);

    }

}
