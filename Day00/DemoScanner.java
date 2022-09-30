package Day00;

import java.time.LocalDate;
import java.util.Scanner;

public class DemoScanner {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        System.out.println("请输入用户名：");

        String username = myObj.next();
        System.out.println("您的用户名是： \n" + username);
        System.out.println("-------------");
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入阁下的姓名，年龄和收入：");
        String s = sc.next();
        int age = sc.nextInt();
        double salary = sc.nextDouble();
        System.out.println(s + "今年" + age + "岁了，" + "工资是" + salary);

        System.out.println("------------");
        LocalDate myLocalDate = LocalDate.now();
        System.out.println(myLocalDate);
    }
}
