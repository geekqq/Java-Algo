package Day30;

public class OrderFoodOption {
    public static void main(String[] args) {
        double money1 = 24 + 8 + 3;
        money1 = (money1 >= 30 ? money1 * 0.8 : money1);
        double money2 = 16 + 8 + 3;
        double money = money1 < money2 ? money1 : money2;
        System.out.println("点这三样东西最少要花：" + money + "元钱。");
    }
}
