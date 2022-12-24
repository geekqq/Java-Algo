package Day113;

class Animal {
    void eat() {
        System.out.println("animal: eat");
    }
}

class Dog extends Animal {
    void eat() {
        System.out.println("dog: eat");
    }
    void eatTest() {
        this.eat();
        super.eat();
    }
}

public class AnimalDemo {
    public static void main(String[] args) {
        Animal a = new Animal();
        a.eat();
        Dog d = new Dog();
        d.eatTest();
    }
}
