package Day249;

import java.security.Permission;
import java.util.Scanner;

public class FactoryPatternDemo {
    public static void main(String[] args) {

        try {
            @SuppressWarnings("resource")
            Scanner sc = new Scanner(System.in);
            FoodFactory foodFactory = new FoodFactory();
            Food food = foodFactory.getFood(sc.nextLine());
            System.out.println("The factory returned " + food.getClass());
            System.out.println(food.getType());
        } catch (Exception e) {
            System.out.println("Unsuccessful Termination!!");
        }
    }
}


interface Food {
    public String getType();
}

class Pizza implements Food {
    public String getType() {
        return "Someone ordered a Fast Food!";
    }
}

class Cake implements Food {
    public String getType() {
        return "Someone ordered a Dessert!";
    }
}

class FoodFactory {
    public Food getFood(String order) {
        if (order.equalsIgnoreCase("pizza")) {
            return new Pizza();
        } else if (order.equalsIgnoreCase("cake")) {
            return new Cake();
        }
        return null;
    } //End of getFood method
} //End of factory class