package Day09;

public class DemoSelfPlusPlus {
    public static void main(String[] args) {
        int x = 5, y;
        float fx = 5.5f, fy;
        char cx = 'B', cy;

        System.out.println("==========对整数的自增和自减============");
        y = x++;
        System.out.printf("y = x++ 的结果为：%d, %d\n", x, y);
        y = x--;
        System.out.printf("y = x-- 的结果为：%d, %d\n", x, y);
        y= ++x;
        System.out.printf("y = ++x 的结果为：%d, %d\n", x, y);
        y = --x;
        System.out.printf("y = --x 的结果为：%d, %d\n", x, y);
        System.out.println("==========对小数的自增和自减============");
        fy = fx++;
        System.out.printf("fy = fx++ 的结果为：%f, %f\n", fx, fy);
        fy = fx--;
        System.out.printf("fy = fx-- 的结果为：%f, %f\n", fx, fy);
        fy = ++fx;
        System.out.printf("fy = fx++ 的结果为：%f, %f\n", fx, fy);
        fy = --fx;
        System.out.printf("fy = --fx 的结果为：%f, %f\n", fx, fy);
        System.out.println("==========对字符的自增和自减============");
        cy = cx++;
        System.out.printf("cy = cx++ 的结果为：%c, %c\n", cx, cy);
        cy = cx--;
        System.out.printf("cy = cx--6 的结果为：%c, %c\n", cx, cy);
        cy = ++cx;
        System.out.printf("cy = ++cx 的结果为：%c, %c\n", cx, cy);
        cy = --cx;
        System.out.printf("cy = --cx 的结果为：%c, %c\n", cx, cy);

    }
}
