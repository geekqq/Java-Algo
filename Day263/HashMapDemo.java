package Day263;

import java.util.HashMap;

public class HashMapDemo {
    public static void main(String[] args) {
        HashMap<String, String> countries = new HashMap<>();
        countries.put("USA", "Washington DC");
        countries.put("India", "New Delhi");
        countries.put("Russia", "Moscow");
        countries.put("China", "Beijing");
        System.out.println(countries);

        //countries.remove("USA");
        System.out.println(countries);
        System.out.println(countries.get("China"));
        //countries.clear();
        System.out.println(countries.size());
        countries.replace("USA", "Hayward");
        System.out.println(countries);
        System.out.println(countries.containsKey("USA"));
        System.out.println(countries.containsKey("England"));
        System.out.println(countries.containsValue("Beijing"));
        System.out.println("------------");
        for (String i : countries.keySet()) {
            System.out.print(i + "\t" + "= ");
            System.out.println(countries.get(i));
        }
    }
}
