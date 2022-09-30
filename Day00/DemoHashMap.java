package Day00;

import java.util.HashMap;

public class DemoHashMap {
    public static void main(String[] args) {
        HashMap<String, String> capitalCities = new HashMap<>();
        capitalCities.put("England", "London");
        capitalCities.put("Germany", "Berlin");
        capitalCities.put("Norway", "Oslo");
        capitalCities.put("USA", "Washington DC");
        System.out.println(capitalCities);

        System.out.println(capitalCities.get("England"));
        System.out.println(capitalCities.remove("England"));
        System.out.println(capitalCities.size());
        System.out.println("----------");
        for (String i : capitalCities.keySet()) {
            System.out.println(i);
        }
        System.out.println("----------");
        for (String i : capitalCities.values()) {
            System.out.println(i);
        }
        for (String i : capitalCities.keySet()) {
            System.out.println("key: " + i + " " + "value: " + capitalCities.get(i));
        }
    }
}
