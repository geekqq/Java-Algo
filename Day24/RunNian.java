package Day24;

import java.util.Scanner;

public class RunNian {
    public static void main(String[] args) {
        System.out.println("请输入需要查询的四位数年份：");
        int year = new Scanner(System.in).nextInt();
        isRunNian(year);
    }

    public static void isRunNian(int year) {
        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
            System.out.println(year + "年是闰年");
        } else {
            System.out.println(year + "年不是闰年");
        }
    }
}
