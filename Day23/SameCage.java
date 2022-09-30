package Day23;

public class SameCage {
    public static void main(String[] args) {
        for (int i = 0, j = 35; i <= 35; i++, j--) {
            if (i * 2 + j * 4 == 94) {
                System.out.println("一共有" + i + "只鸡和" + j + "只鸭！");
            }
        }
    }
}
