package Day31;

public class MathRandom {
    public static void main(String[] args) {
        //Math.random()可以产生[0, 1)的随机浮点数
        System.out.println(Math.random());

        for (int i = 0; i < 100; i++) {
            System.out.print(Math.random() + " ");
        }
    }
}
