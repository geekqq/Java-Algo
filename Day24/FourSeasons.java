package Day24;

import java.util.Scanner;

public class FourSeasons {
    public static void main(String[] args) {
        System.out.println("请输入要查询的月份的数字（1 - 12）：");
        int month = new Scanner(System.in).nextInt();

        switch (month) {
            case 1: case 2: case 3:
                System.out.println("春季");
                break;
            case 4: case 5: case 6:
                System.out.println("夏季");
                break;
            case 7: case 8:case 9:
                System.out.println("秋季");
                break;
            case 10: case 11: case 12:
                System.out.println("冬季");
                break;
            default:
                System.out.println("输入有误！");
        }
    }
}
