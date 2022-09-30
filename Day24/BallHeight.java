package Day24;

public class BallHeight {
    public static void main(String[] args) {
        double height = 100;
        double sum = 100;
        int n = 1;

        while (n < 11) {
            height = height / 2;
            System.out.println("球第" + n +"次落地，弹起的高度是：" + height);
            n++;
            sum += height * 2;
            System.out.println("球第" + n +"次落地，经过的距离是：" + sum);
        }
    }
}
