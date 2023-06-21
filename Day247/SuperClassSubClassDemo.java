package Day247;

import org.intellij.lang.annotations.Flow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SuperClassSubClassDemo {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine().trim();
        Region region = null;
        switch (s) {
            case "WestBengal":
                region = new WestBengal();
                break;
            case "AndHraPradesh":
                region = new AndhraPradesh();
                break;
        }
        Flower flower = region.yourNationalFlower();
        System.out.println(flower.whatsYourName());
    }
}
class Flower {
    String whatsYourName() {
        return "I have many types and names!";
    }
}

class Jasmin extends Flower {
    @Override
    String whatsYourName() {
        return "Jasmin";
    }
}

class Lily extends Flower {
    @Override
    String whatsYourName() {
        return "Lily";
    }
}

class Region {
    Flower yourNationalFlower() {
        return new Flower();
    }
}

class WestBengal extends Region {
    @Override
    Jasmin yourNationalFlower() {
        return new Jasmin();
    }
}

class AndhraPradesh extends Region {
    @Override
    Lily yourNationalFlower() {
        return new Lily();
    }
}