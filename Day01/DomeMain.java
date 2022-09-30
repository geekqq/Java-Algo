package Day01;

public class DomeMain {
    public static void main(String[] args) {
        Hero hero = new Hero();
        hero.setAge(29);
        hero.setName("周杰伦");

        Weapon weapon = new Weapon("双节棍");
        hero.setWeapon(weapon);
        hero.attack();
    }


}
